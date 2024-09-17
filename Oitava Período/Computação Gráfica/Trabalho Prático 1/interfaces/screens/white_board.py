import tkinter as tk
from tkinter import ttk
from tkinter import messagebox

from application.services.geometry_transformation_service import GeometryTransformation
from application.services.paint_service import PaintService
from application.services.shape_collection_service import ShapeCollectionService
from domain.entities.shape_collection import ShapeCollection
from domain.entities.point import Point

class PaintApp:

    def __init__(self, root):
        self.shape_collection = ShapeCollection()
        self.shape_collection_service = ShapeCollectionService()
        self.geometry_transformation_service = GeometryTransformation()
        self.n_point = 0
        self.last_point = None

        self.algorithm_option = tk.StringVar()
        self.transformation_option = tk.StringVar()
        self.algorithm_menu = None
        self.transformation_menu = None
        self.mode = None
        self.algorithm = None
        self.transformation_algorithm = None
        self.btn_clip = None
        self.btn_circle = None
        self.btn_line = None

        self.root = root
        self.root.title("White Board")

        self.canvas = tk.Canvas(self.root, bg='white', width=800, height=600)
        self.canvas.pack()

        self.menu_header()
        self.create_shape_menu()
        self.create_transformation_menu()
        self.hide_transformation_menu()

        self.canvas.bind("<Button-1>", self.register_point)

    def menu_header(self):
        self.btn_shape_mode = tk.Button(self.root, text="Formas", command=self.show_shape_menu)
        self.btn_shape_mode.pack(side=tk.TOP, padx=10, pady=10)

        self.btn_transformation_mode = tk.Button(self.root, text="Transformações", command=self.show_transformation_menu)
        self.btn_transformation_mode.pack(side=tk.TOP, padx=10, pady=10)

    def create_shape_menu(self):
        self.btn_line = tk.Button(self.root, text="Line", command=self.select_line)
        self.btn_circle = tk.Button(self.root, text="Circle", command=self.select_circle)
        self.btn_clip = tk.Button(self.root, text="Clipping", command=self.select_clip)

        self.algorithm_menu = ttk.Combobox(self.root, textvariable=self.algorithm_option)
        self.algorithm_menu.bind("<<ComboboxSelected>>", self.update_algorithm)

        self.btn_clear_shapes = tk.Button(self.root, text="Clear", command=self.clear_button_handle)

    def create_transformation_menu(self):
        self.transformation_menu = ttk.Combobox(self.root, textvariable=self.transformation_option)
        self.transformation_menu.bind("<<ComboboxSelected>>", self.update_transformation_algorithm)

        self.param_1_label = tk.Label(self.root, text="Param 1:")
        self.param_1_entry = tk.Entry(self.root)

        self.param_2_label = tk.Label(self.root, text="Param 2:")
        self.param_2_entry = tk.Entry(self.root)

        self.btn_transform = tk.Button(self.root, text="Apply Transformation", command=self.apply_transformation)
        self.btn_clear_transformations = tk.Button(self.root, text="Clear", command=self.clear_button_handle)

    def show_shape_menu(self):
        self.hide_transformation_menu()
        self.btn_line.pack(side=tk.LEFT, padx=10, pady=10)
        self.btn_circle.pack(side=tk.LEFT, padx=10, pady=10)
        self.btn_clip.pack(side=tk.LEFT, padx=10, pady=10)
        self.algorithm_menu.pack(side=tk.LEFT, padx=10, pady=10)
        self.btn_clear_shapes.pack(side=tk.LEFT, padx=10, pady=10)
        self.update_dropdown_options()

    def hide_shape_menu(self):
        self.btn_line.pack_forget()
        self.btn_circle.pack_forget()
        self.btn_clip.pack_forget()
        self.algorithm_menu.pack_forget()
        self.btn_clear_shapes.pack_forget()

    def show_transformation_menu(self):
        self.hide_shape_menu()
        self.transformation_menu.pack(side=tk.LEFT, padx=10, pady=10)
        self.param_1_label.pack(side=tk.LEFT, padx=10, pady=10)
        self.param_1_entry.pack(side=tk.LEFT, padx=10, pady=10)
        self.param_2_label.pack(side=tk.LEFT, padx=10, pady=10)
        self.param_2_entry.pack(side=tk.LEFT, padx=10, pady=10)
        self.btn_transform.pack(side=tk.LEFT, padx=10, pady=10)
        self.btn_clear_transformations.pack(side=tk.LEFT, padx=10, pady=10)
        self.update_transformation_dropdown_options()

    def hide_transformation_menu(self):
        self.transformation_menu.pack_forget()
        self.param_1_label.pack_forget()
        self.param_1_entry.pack_forget()
        self.param_2_label.pack_forget()
        self.param_2_entry.pack_forget()
        self.btn_transform.pack_forget()
        self.btn_clear_transformations.pack_forget()

    def update_dropdown_options(self):
        self.algorithm_menu['values'] = PaintService.algorithm_list(self.mode)

    def update_transformation_dropdown_options(self):
        self.transformation_menu['values'] = GeometryTransformation.algorithm_list()

    def update_algorithm(self, event=None):
        self.algorithm = self.algorithm_option.get()

    def update_transformation_algorithm(self, event=None):
        self.transformation_algorithm = self.transformation_option.get()

    def select_line(self):
        self.mode = 'line'
        self.update_dropdown_options()

    def select_circle(self):
        self.mode = 'circle'
        self.update_dropdown_options()

    def select_clip(self):
        self.mode = 'clip'
        self.update_dropdown_options()

    def clear_button_handle(self):
        self.canvas.delete("all")
        self.shape_collection = ShapeCollection()
        self.n_point = 0
        self.last_point = None

    def register_point(self, event):
        self.n_point += 1
        x, y = event.x, event.y
        now_point = Point(x, y)
        if self.n_point % 2 == 0:
            if not self.mode or not self.algorithm:
                messagebox.showerror("Error", "Needed to select a shape or algorithm")
                self.n_point -= 1
                return

            points_to_draw = self.get_points(now_point)
            self.paint_points(points_to_draw)
            PaintApp.delete_by_color(self.canvas, 'red')
        else:
            self.canvas.create_line(x, y, x + 1, y, fill='red')
        self.last_point = now_point

    def get_points(self, now_point):
        shape = self.shape_collection_service.choose_shape(self.mode)()
        algorithm = self.shape_collection_service.choose_shape_algorithm(self.mode, self.algorithm)
        self.shape_collection.add_shape(shape)
        return shape.draw(algorithm, self.last_point, now_point)

    def paint_points(self, points_to_draw):
        for point in points_to_draw:
            self.canvas.create_rectangle(point.x, point.y, point.x, point.y, fill='black')

    def apply_transformation(self):
        if not self.transformation_algorithm:
            messagebox.showerror("Error", "Please select a transformation algorithm")
            return

        param_1 = self.param_1_entry.get()
        param_2 = self.param_2_entry.get()

        if not param_1 or not param_2:
            messagebox.showerror("Error", "Please provide both parameters for the transformation")
            return

        algorithm = self.geometry_transformation_service.choose_algorithm(self.transformation_algorithm)
        self.shape_collection.execute_transformation(algorithm, params=[int(self.param_1_entry.get()), int(self.param_2_entry.get())])
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
