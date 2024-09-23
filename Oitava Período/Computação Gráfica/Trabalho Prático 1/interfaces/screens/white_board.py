import tkinter as tk
from tkinter import ttk, messagebox

from application.services.geometry_transformation_service import GeometryTransformation
from application.services.paint_service import PaintService
from application.services.shape_collection_service import ShapeCollectionService
from domain.entities.shape_collection import ShapeCollection
from domain.entities.point import Point

class PaintApp:

    def __init__(self, root):
        self.root = root
        self.root.title("White Board")
        self.root.geometry("1024x768")
        self.root.configure(bg='black')

        self.shape_collection = ShapeCollection()
        self.shape_collection_service = ShapeCollectionService()
        self.geometry_transformation_service = GeometryTransformation()
        self.n_point = 0
        self.last_point = None
        self.mode = None
        self.algorithm = None
        self.transformation_algorithm = None

        self.algorithm_option = tk.StringVar(value="Select algorithm")
        self.transformation_option = tk.StringVar(value="Select transformation")
        self.reflexion_option = tk.StringVar(value="x")

        self.create_layout()

    def create_layout(self):
        self.left_frame = tk.Frame(self.root, bg='black', width=200, height=768)
        self.left_frame.pack(side=tk.LEFT, fill=tk.Y, padx=10, pady=10)

        self.canvas_frame = tk.Frame(self.root, bg='black')
        self.canvas_frame.pack(side=tk.LEFT, padx=10, pady=10, expand=True)

        self.right_frame = tk.Frame(self.root, bg='black', width=200, height=768)
        self.right_frame.pack(side=tk.LEFT, fill=tk.Y, padx=10, pady=10)

        self.canvas = tk.Canvas(self.canvas_frame, bg='white', width=600, height=600, bd=0, highlightthickness=0)
        self.canvas.pack()

        self.object_list_label = tk.Label(self.left_frame, text="List Object", bg='black', fg='white', font=('Arial', 12))
        self.object_list_label.pack(pady=10)

        self.object_listbox = tk.Listbox(self.left_frame, bg='#222', fg='white', font=('Arial', 10))
        self.object_listbox.pack(pady=10, fill=tk.BOTH, expand=True)
        self.object_listbox.bind("<<ListboxSelect>>", self.enable_clear_one)

        self.clear_frame = tk.Frame(self.left_frame, bg='black')
        self.clear_frame.pack(pady=10)

        self.clear_btn = tk.Button(self.clear_frame, text="Clear All", command=self.clear_button_handle, bg='#555', fg='white', relief=tk.FLAT, font=('Arial', 10), width=10)
        self.clear_btn.pack(side=tk.LEFT, padx=5)

        self.btn_clear_one = tk.Button(self.clear_frame, text="Clear One", command=self.clear_one, state=tk.DISABLED, bg='#555', fg='white', relief=tk.FLAT, font=('Arial', 10), width=10)
        self.btn_clear_one.pack(side=tk.LEFT, padx=5)

        # Sessão de Formas
        self.shape_section_label = tk.Label(self.right_frame, text="Shapes", bg='black', fg='white', font=('Arial', 12))
        self.shape_section_label.pack(pady=10)

        self.btn_line = tk.Button(self.right_frame, text="Line", command=self.select_line, width=15, bg='#555', fg='white', relief=tk.FLAT, font=('Arial', 10))
        self.btn_line.pack(pady=5)

        self.btn_circle = tk.Button(self.right_frame, text="Circle", command=self.select_circle, width=15, bg='#555', fg='white', relief=tk.FLAT, font=('Arial', 10))
        self.btn_circle.pack(pady=5)

        self.btn_clip = tk.Button(self.right_frame, text="Clipping", command=self.select_clip, width=15, bg='#555', fg='white', relief=tk.FLAT, font=('Arial', 10))
        self.btn_clip.pack(pady=5)

        self.algorithm_menu = ttk.Combobox(self.right_frame, textvariable=self.algorithm_option, state="readonly", width=15)
        self.algorithm_menu.pack(pady=5)
        self.algorithm_menu.bind("<<ComboboxSelected>>", self.update_algorithm)

        # Sessão de Transformações
        self.transformation_section_label = tk.Label(self.right_frame, text="Transformations", bg='black', fg='white', font=('Arial', 12))
        self.transformation_section_label.pack(pady=10)

        self.transformation_menu = ttk.Combobox(self.right_frame, textvariable=self.transformation_option, state="readonly", width=15)
        self.transformation_menu.pack(pady=5)
        self.transformation_menu['values'] = GeometryTransformation.algorithm_list()
        self.transformation_menu.bind("<<ComboboxSelected>>", self.update_transformation_menu)

        self.param_frame = tk.Frame(self.right_frame, bg='black')
        self.param_frame.pack(pady=10)

        self.param_1_container = tk.Frame(self.param_frame, bg='black')
        self.param_1_container.pack(pady=5)

        self.param_1_label = tk.Label(self.param_1_container, text="", bg='black', fg='white', font=('Arial', 10))
        self.param_1_label.pack()

        self.param_1_controls = tk.Frame(self.param_1_container, bg='black')
        self.param_1_controls.pack()

        self.param_1_dec_btn = tk.Button(self.param_1_controls, text="-", command=lambda: self.decrement_value(self.param_1_entry), bg='#555', fg='white', relief=tk.FLAT, font=('Arial', 10), width=5)
        self.param_1_entry = tk.Entry(self.param_1_controls, width=5)
        self.param_1_inc_btn = tk.Button(self.param_1_controls, text="+", command=lambda: self.increment_value(self.param_1_entry), bg='#555', fg='white', relief=tk.FLAT, font=('Arial', 10), width=5)

        self.param_1_dec_btn.pack(side=tk.LEFT)
        self.param_1_entry.pack(side=tk.LEFT)
        self.param_1_inc_btn.pack(side=tk.LEFT)

        self.param_2_container = tk.Frame(self.param_frame, bg='black')
        self.param_2_container.pack(pady=5)

        self.param_2_label = tk.Label(self.param_2_container, text="", bg='black', fg='white', font=('Arial', 10))
        self.param_2_label.pack()

        self.param_2_controls = tk.Frame(self.param_2_container, bg='black')
        self.param_2_controls.pack()

        self.param_2_dec_btn = tk.Button(self.param_2_controls, text="-", command=lambda: self.decrement_value(self.param_2_entry), bg='#555', fg='white', relief=tk.FLAT, font=('Arial', 10), width=5)
        self.param_2_entry = tk.Entry(self.param_2_controls, width=5)
        self.param_2_inc_btn = tk.Button(self.param_2_controls, text="+", command=lambda: self.increment_value(self.param_2_entry), bg='#555', fg='white', relief=tk.FLAT, font=('Arial', 10), width=5)

        self.param_2_dec_btn.pack(side=tk.LEFT)
        self.param_2_entry.pack(side=tk.LEFT)
        self.param_2_inc_btn.pack(side=tk.LEFT)

        self.reflexion_menu = ttk.Combobox(self.param_frame, textvariable=self.reflexion_option, state="readonly", width=10)

        self.btn_apply_transformation = tk.Button(self.right_frame, text="Apply Transformation", command=self.apply_transformation, width=15, bg='#555', fg='white', relief=tk.FLAT, font=('Arial', 10))
        self.btn_apply_transformation.pack(pady=5)

        self.hide_param_entries()

        self.canvas.bind("<Button-1>", self.register_point)

    def hide_param_entries(self):
        self.param_1_container.pack_forget()
        self.param_2_container.pack_forget()
        self.reflexion_menu.pack_forget()

    def clear_transformation_fields(self):
        self.param_1_entry.delete(0, tk.END)
        self.param_2_entry.delete(0, tk.END)
        self.reflexion_option.set("x")

    def update_transformation_menu(self, event=None):
        self.hide_param_entries()
        self.clear_transformation_fields()
        selected = self.transformation_option.get()

        if selected == 'translation':
            self.param_1_label.config(text="Translation X:")
            self.param_1_container.pack(pady=5)
            self.param_2_label.config(text="Translation Y:")
            self.param_2_container.pack(pady=5)

        elif selected == 'rotation':
            self.param_1_label.config(text="Degrees:")
            self.param_1_container.pack(pady=5)

        elif selected == 'scale':
            self.param_1_label.config(text="Scale X:")
            self.param_1_container.pack(pady=5)
            self.param_2_label.config(text="Scale Y:")
            self.param_2_container.pack(pady=5)

        elif selected == 'reflexion':
            self.reflexion_menu['values'] = ['x', 'y', 'xy']
            self.reflexion_menu.pack()

    def increment_value(self, entry):
        value = entry.get()
        try:
            value = int(value) + 1
        except ValueError:
            value = 1
        entry.delete(0, tk.END)
        entry.insert(0, value)

    def decrement_value(self, entry):
        value = entry.get()
        try:
            value = int(value) - 1
        except ValueError:
            value = 0
        entry.delete(0, tk.END)
        entry.insert(0, value)

    def clear_one(self):
        selected = self.object_listbox.curselection()
        if selected:
            self.object_listbox.delete(selected)

    def enable_clear_one(self, event):
        if self.object_listbox.curselection():
            self.btn_clear_one.config(state=tk.NORMAL)
        else:
            self.btn_clear_one.config(state=tk.DISABLED)

    def select_line(self):
        self.mode = 'line'
        self.clear_algorithm_menu()
        self.btn_line.config(bg='green')
        self.btn_circle.config(bg='#555')
        self.btn_clip.config(bg='#555')
        self.update_algorithm_menu()

    def select_circle(self):
        self.mode = 'circle'
        self.clear_algorithm_menu()
        self.btn_circle.config(bg='green')
        self.btn_line.config(bg='#555')
        self.btn_clip.config(bg='#555')
        self.update_algorithm_menu()

    def select_clip(self):
        self.mode = 'clip'
        self.clear_algorithm_menu()
        self.btn_clip.config(bg='green')
        self.btn_line.config(bg='#555')
        self.btn_circle.config(bg='#555')
        self.update_algorithm_menu()

    def update_algorithm_menu(self):
        self.algorithm_menu['values'] = PaintService.algorithm_list(self.mode)

    def update_algorithm(self, event=None):
        self.algorithm = self.algorithm_option.get()

    def clear_algorithm_menu(self):
        self.algorithm_menu.set("Select algorithm")

    def clear_button_handle(self):
        self.canvas.delete("all")
        self.shape_collection = ShapeCollection()
        self.n_point = 0
        self.last_point = None

    def register_point(self, event):
        if not self.mode or not self.algorithm:
            messagebox.showerror("Error", "You need to select a shape and an algorithm")
            return

        x, y = event.x, event.y
        current_point = Point(x, y)
        self.n_point += 1
        if self.n_point % 2 == 0:
            points = self.get_shape_points(current_point)
            self.paint_points(points)
            self.canvas.create_line(self.last_point.x, self.last_point.y, self.last_point.x + 1, self.last_point.y, fill='red')
            self.canvas.create_line(current_point.x, current_point.y, current_point.x + 1, current_point.y, fill='red')
        else:
            self.canvas.create_line(x, y, x + 1, y, fill='red')
        self.last_point = current_point

    def get_shape_points(self, current_point):
        shape = self.shape_collection_service.choose_shape(self.mode)()
        algorithm = self.shape_collection_service.choose_shape_algorithm(self.mode, self.algorithm)
        self.shape_collection.add_shape(shape)
        return shape.draw(algorithm, self.last_point, current_point)

    def paint_points(self, points):
        for point in points:
            self.canvas.create_line(point.x, point.y, point.x + 1, point.y, fill='black')

    def apply_transformation(self):
        transformation_option = self.transformation_option.get()

        if not transformation_option:
            messagebox.showerror("Error", "Please select a transformation algorithm")
            return

        param_1 = self.param_1_entry.get()
        param_2 = self.param_2_entry.get()
        menu_type = self.reflexion_menu.get()

        if not (param_1 or param_2 or (transformation_option == 'reflexion')):
            messagebox.showerror("Error", "Please provide at least parameters for the transformation")
            return

        algorithm = self.geometry_transformation_service.choose_algorithm(self.transformation_option.get())

        if transformation_option == 'reflexion':
            params = menu_type
        else:
            params = [int(param_1), int(param_2)]

        self.shape_collection.execute_transformation(algorithm, params=params)
        PaintApp.delete_by_color(self.canvas, 'black')
        self.paint_all_shapes()

    def paint_all_shapes(self):
        for shape in self.shape_collection.shapes:
            self.paint_points(shape.points_collection)

    @staticmethod
    def delete_by_color(canvas, color):
        for item in canvas.find_all():
            item_color = canvas.itemcget(item, "fill")
            if item_color == color:
                canvas.delete(item)

if __name__ == "__main__":
    root = tk.Tk()
    app = PaintApp(root)
    root.mainloop()
