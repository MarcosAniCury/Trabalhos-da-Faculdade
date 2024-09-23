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

        self.shape_collection = ShapeCollection()
        self.shape_collection_service = ShapeCollectionService()
        self.geometry_transformation_service = GeometryTransformation()

        self.n_point = 0
        self.last_point = None
        self.mode = None
        self.algorithm = None
        self.transformation_algorithm = None

        self.algorithm_option = tk.StringVar(value="Don't need additional inputs")
        self.transformation_option = tk.StringVar(value="Select transformation")
        self.reflexion_option = tk.StringVar(value="x")

        self.create_layout()

    def create_layout(self):
        self.left_frame = tk.Frame(self.root, bg='#333', width=200, height=768)
        self.left_frame.pack(side=tk.LEFT, fill=tk.Y, padx=10, pady=10)

        self.canvas_frame = tk.Frame(self.root, bg='#444')
        self.canvas_frame.pack(side=tk.LEFT, padx=10, pady=10, expand=True)

        self.right_frame = tk.Frame(self.root, bg='#333', width=200, height=768)
        self.right_frame.pack(side=tk.LEFT, fill=tk.Y, padx=10, pady=10)

        self.canvas = tk.Canvas(self.canvas_frame, bg='white', width=600, height=600)
        self.canvas.pack()

        self.object_list_label = tk.Label(self.left_frame, text="List Object", bg='#333', fg='white')
        self.object_list_label.pack(pady=10)

        self.object_listbox = tk.Listbox(self.left_frame, bg='#111', fg='white')
        self.object_listbox.pack(pady=10, fill=tk.BOTH, expand=True)
        self.object_listbox.bind("<<ListboxSelect>>", self.enable_clear_one)

        self.clear_frame = tk.Frame(self.left_frame)
        self.clear_frame.pack(pady=10)

        self.clear_btn = tk.Button(self.clear_frame, text="Clear All", command=self.clear_button_handle)
        self.clear_btn.pack(side=tk.LEFT, padx=5)

        self.btn_clear_one = tk.Button(self.clear_frame, text="Clear One", command=self.clear_one, state=tk.DISABLED)
        self.btn_clear_one.pack(side=tk.LEFT, padx=5)

        self.shape_label = tk.Label(self.right_frame, text="Shapes/Transformations", bg='#333', fg='white')
        self.shape_label.pack(pady=10)

        self.btn_line = tk.Button(self.right_frame, text="Line", command=self.select_line, width=15)
        self.btn_line.pack(pady=5)

        self.btn_circle = tk.Button(self.right_frame, text="Circle", command=self.select_circle, width=15)
        self.btn_circle.pack(pady=5)

        self.btn_clip = tk.Button(self.right_frame, text="Clipping", command=self.select_clip, width=15)
        self.btn_clip.pack(pady=5)

        self.transformation_menu = ttk.Combobox(self.right_frame, textvariable=self.transformation_option,
                                                state="readonly", width=15)
        self.transformation_menu.pack(pady=5)
        self.transformation_menu['values'] = ['Translation', 'Rotation', 'Scale', 'Reflection']
        self.transformation_menu.bind("<<ComboboxSelected>>", self.update_transformation_menu)

        self.param_frame = tk.Frame(self.right_frame, bg='#333')
        self.param_frame.pack(pady=10)

        self.param_1_label = tk.Label(self.param_frame, text="", bg='#333', fg='white')
        self.param_1_entry = tk.Entry(self.param_frame, width=10)
        self.param_1_inc_btn = tk.Button(self.param_frame, text="+",
                                         command=lambda: self.increment_value(self.param_1_entry))
        self.param_1_dec_btn = tk.Button(self.param_frame, text="-",
                                         command=lambda: self.decrement_value(self.param_1_entry))

        self.param_2_label = tk.Label(self.param_frame, text="", bg='#333', fg='white')
        self.param_2_entry = tk.Entry(self.param_frame, width=10)
        self.param_2_inc_btn = tk.Button(self.param_frame, text="+",
                                         command=lambda: self.increment_value(self.param_2_entry))
        self.param_2_dec_btn = tk.Button(self.param_frame, text="-",
                                         command=lambda: self.decrement_value(self.param_2_entry))

        self.reflexion_menu = ttk.Combobox(self.param_frame, textvariable=self.reflexion_option, state="readonly",
                                           width=10)

        self.btn_apply_transformation = tk.Button(self.right_frame, text="Apply Transformation",
                                                  command=self.apply_transformation, width=15)
        self.btn_apply_transformation.pack(pady=5)

        self.hide_param_entries()

    def hide_param_entries(self):
        self.param_1_label.pack_forget()
        self.param_1_entry.pack_forget()
        self.param_1_inc_btn.pack_forget()
        self.param_1_dec_btn.pack_forget()
        self.param_2_label.pack_forget()
        self.param_2_entry.pack_forget()
        self.param_2_inc_btn.pack_forget()
        self.param_2_dec_btn.pack_forget()
        self.reflexion_menu.pack_forget()

    def update_transformation_menu(self, event=None):
        self.hide_param_entries()
        selected = self.transformation_option.get()

        if selected == 'Translation':
            self.param_1_label.config(text="Translation X:")
            self.param_1_label.pack()
            self.param_1_entry.pack()
            self.param_1_inc_btn.pack()
            self.param_1_dec_btn.pack()

            self.param_2_label.config(text="Translation Y:")
            self.param_2_label.pack()
            self.param_2_entry.pack()
            self.param_2_inc_btn.pack()
            self.param_2_dec_btn.pack()

        elif selected == 'Rotation':
            self.param_1_label.config(text="Degrees:")
            self.param_1_label.pack()
            self.param_1_entry.pack()
            self.param_1_inc_btn.pack()
            self.param_1_dec_btn.pack()

        elif selected == 'Scale':
            self.param_1_label.config(text="Scale X:")
            self.param_1_label.pack()
            self.param_1_entry.pack()
            self.param_1_inc_btn.pack()
            self.param_1_dec_btn.pack()

            self.param_2_label.config(text="Scale Y:")
            self.param_2_label.pack()
            self.param_2_entry.pack()
            self.param_2_inc_btn.pack()
            self.param_2_dec_btn.pack()

        elif selected == 'Reflection':
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

    def select_circle(self):
        self.mode = 'circle'

    def select_clip(self):
        self.mode = 'clip'

    def clear_button_handle(self):
        self.canvas.delete("all")
        self.shape_collection = ShapeCollection()
        self.n_point = 0
        self.last_point = None

    def register_point(self, event):
        x, y = event.x, event.y
        current_point = Point(x, y)
        self.n_point += 1
        if self.n_point % 2 == 0:
            if not self.mode:
                messagebox.showerror("Error", "You need to select a shape")
                self.n_point -= 1
                return

            points = self.get_shape_points(current_point)
            self.paint_points(points)
        else:
            self.canvas.create_line(x, y, x + 1, y, fill='red')
        self.last_point = current_point

    def get_shape_points(self, current_point):
        shape = self.shape_collection_service.choose_shape(self.mode)()
        self.shape_collection.add_shape(shape)
        return shape.draw(self.last_point, current_point)

    def paint_points(self, points):
        for point in points:
            self.canvas.create_line(point.x, point.y, point.x + 1, point.y, fill='black')

    def apply_transformation(self):
        if not self.transformation_option.get():
            messagebox.showerror("Error", "Please select a transformation algorithm")
            return

        if self.transformation_option.get() == 'Reflection':
            param_1 = self.reflexion_option.get()
            param_2 = None  # Reflection does not require a second parameter
            # Map the reflection option to numerical values expected by the algorithm
            reflection_map = {'x': 0, 'y': 1, 'xy': 2}
            param_1 = reflection_map[param_1]
        else:
            param_1 = self.param_1_entry.get()
            param_2 = self.param_2_entry.get()

            if not param_1 or not param_2:
                messagebox.showerror("Error", "Both parameters are required for this transformation")
                return

            try:
                param_1 = int(param_1)
                param_2 = int(param_2)
            except ValueError:
                messagebox.showerror("Error", "Parameters must be numeric")
                return

        algorithm = self.geometry_transformation_service.choose_algorithm(self.transformation_option.get())
        self.shape_collection.execute_transformation(algorithm, params=[param_1, param_2])
        self.paint_all_shapes()

    def paint_all_shapes(self):
        self.canvas.delete("all")
        for shape in self.shape_collection.shapes:
            self.paint_points(shape.points_collection)


if __name__ == "__main__":
    root = tk.Tk()
    app = PaintApp(root)
    root.mainloop()
