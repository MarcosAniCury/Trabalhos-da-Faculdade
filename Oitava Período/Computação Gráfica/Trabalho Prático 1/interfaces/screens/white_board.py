import tkinter as tk
from tkinter import ttk
from tkinter import messagebox
from application.services.paint_service import PaintService
from application.services.shape_collection_service import ShapeCollectionService
from domain.entities.shape_collection import ShapeCollection
from domain.entities.point import Point

#TODO: Need implement all clipping algorithm and geometric transformations (translação, rotação, escala e reflexões X/Y/XY com fatores de transformação informados pelo usuário (sem uso de valores fixos))

class PaintApp:

    def __init__(self, root):
        self.shape_collection = ShapeCollection()
        self.shape_collection_service = ShapeCollectionService()
        self.n_point = 0
        self.last_point = None

        self.algorithm_option = tk.StringVar()
        self.algorithm_menu = None
        self.mode = None
        self.algorithm = None
        self.btn_clip = None
        self.btn_circle = None
        self.btn_line = None

        self.root = root
        self.root.title("White Board")

        self.canvas = tk.Canvas(self.root, bg='white', width=800, height=600)
        self.canvas.pack()

        self.menu_footer()
        self.menu_footer_dropdown()
        self.menu_footer_clear()

        self.canvas.bind("<Button-1>", self.register_point)

    def menu_footer(self):
        self.btn_line = tk.Button(self.root, text="Line", command=self.select_line)
        self.btn_line.pack(side=tk.LEFT, padx=10, pady=10)
        self.btn_circle = tk.Button(self.root, text="Circle", command=self.select_circle)
        self.btn_circle.pack(side=tk.LEFT, padx=10, pady=10)
        self.btn_clip = tk.Button(self.root, text="Clipping", command=self.select_clip)
        self.btn_clip.pack(side=tk.LEFT, padx=10, pady=10)

    def menu_footer_dropdown(self):
        self.algorithm_menu = ttk.Combobox(self.root, textvariable=self.algorithm_option)
        self.algorithm_menu.pack(side=tk.LEFT, padx=10, pady=10)
        self.algorithm_menu.bind("<<ComboboxSelected>>", self.update_algorithm)
        self.update_dropdown_options()

    def menu_footer_clear(self):
        self.btn_clip = tk.Button(self.root, text="Clear", command=self.clear_button_handle)
        self.btn_clip.pack(side=tk.LEFT, padx=10, pady=10)

    def update_dropdown_options(self):
        self.algorithm_menu['values'] = PaintService.algorithm_list(self.mode)

    def update_algorithm(self, event=None):
        self.algorithm = self.algorithm_option.get()

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

    @staticmethod
    def delete_by_color(canvas, color):
        for item in canvas.find_all():
            item_color = canvas.itemcget(item, "fill")

            if item_color == color:
                canvas.delete(item)