import tkinter as tk


class PaintApp:
    def __init__(self, root):
        self.root = root
        self.root.title("Quadro Branco Simples")

        self.canvas = tk.Canvas(self.root, bg='white', width=800, height=600)
        self.canvas.pack()

        self.canvas.bind("<Button-1>", self.paint)

    def paint(self, event):
        x, y = event.x, event.y
        self.canvas.create_oval(x - 2, y - 2, x + 2, y + 2, fill='black', outline='black')


if __name__ == "__main__":
    root = tk.Tk()
    app = PaintApp(root)
    root.mainloop()
