import tkinter as tk
from tkinter import ttk

from application.services.paint_service import PaintService

class PaintApp:

    def __init__(self, root):
        self.algorithm_option = tk.StringVar()
        self.algorithm_menu = None
        self.mode = None
        self.algorithm = None
        self.btn_circle = None
        self.btn_line = None

        self.root = root
        self.root.title("White Board")

        self.canvas = tk.Canvas(self.root, bg='white', width=800, height=600)
        self.canvas.pack()

        self.menu_footer()
        self.menu_footer_dropdown()

        self.canvas.bind("<Button-1>", self.paint)

    def menu_footer(self):
        self.btn_line = tk.Button(self.root, text="Line", command=self.select_line)
        self.btn_line.pack(side=tk.LEFT, padx=10, pady=10)
        self.btn_circle = tk.Button(self.root, text="Circle", command=self.select_circle)
        self.btn_circle.pack(side=tk.LEFT, padx=10, pady=10)

    def menu_footer_dropdown(self):
        self.algorithm_menu = ttk.Combobox(self.root, textvariable=self.algorithm_option)
        self.algorithm_menu.pack(side=tk.LEFT, padx=10, pady=10)
        self.algorithm_menu.bind("<<ComboboxSelected>>", self.update_algorithm)
        self.update_dropdown_options()

    def update_dropdown_options(self):
        self.algorithm_menu['values'] = PaintService.algorithm_list(self.mode)

    def update_algorithm(self, event=None):
        self.algorithm = self.algorithm_option.get()
        print(f"Algoritmo atualizado: {self.algorithm}")

    def select_line(self):
        self.mode = 'line'
        self.update_dropdown_options()
        print(f"Modo: {self.mode}, Algoritmo: {self.algorithm}")

    def select_circle(self):
        self.mode = 'circle'
        self.update_dropdown_options()
        print(f"Modo: {self.mode}, Algoritmo: {self.algorithm}")

    @staticmethod
    def paint(canvas, x, y, color='black'):
        canvas.create_line(x, y, x + 1, y, fill=color)