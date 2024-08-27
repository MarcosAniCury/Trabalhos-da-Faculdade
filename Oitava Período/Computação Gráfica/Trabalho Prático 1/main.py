import tkinter as tk
from interfaces.screens.white_board import PaintApp

if __name__ == "__main__":
    root = tk.Tk()
    app = PaintApp(root)
    root.mainloop()
