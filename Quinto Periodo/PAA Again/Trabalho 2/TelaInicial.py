from tkinter import *
from tkinter import ttk

class TransportPlanning:
    def __init__(self, root):
        self.root = root
        self.root.title("Transport Planning")
        self.root.geometry("500x500")
        self.root.resizable(False, False)
        self.root.configure(background="white")

        # Title
        title_label = Label(root, text="Transport Cargo Planning", font=("Arial", 16), bg="white")
        title_label.grid(row=0, column=0, columnspan=2, padx=10, pady=10)

        # Buttons
        bruteforce_button = Button(root, text="Brute Force", width=15, height=2, command=self.show_bruteforce_text)
        bruteforce_button.grid(row=1, column=0, padx=(10, 5), pady=5, sticky="E")

        bnb_button = Button(root, text="Branch and Bound", width=15, height=2, command=self.show_bnb_text)
        bnb_button.grid(row=1, column=1, padx=(5, 10), pady=5, sticky="W")

        # Text Label
        self.text_label = Label(root, text="", font=("Arial", 14), bg="white")
        self.text_label.grid(row=2, column=0, columnspan=2, padx=10, pady=5)

        # Switch Frame
        self.frame_switch = Frame(root, width=500, height=50)
        self.frame_switch.configure(background="white")
        self.frame_switch.grid(row=3, column=0, columnspan=2, pady=10)

        self.label_switch = Label(self.frame_switch, text="Train:", font=("Arial", 14), bg="white")
        self.label_switch.grid(row=0, column=0, padx=5, sticky="E")

        self.switch_var = StringVar(value="No")
        self.switch = ttk.Combobox(self.frame_switch, textvariable=self.switch_var, values=["No", "Yes"], state="readonly")
        self.switch.grid(row=0, column=1, padx=5, sticky="W")

        # Plot Route Button
        plot_button = Button(root, text="Plot Route", width=15, height=2)
        plot_button.grid(row=4, column=0, columnspan=2, padx=10, pady=5)

        # Center all items
        for i in range(root.grid_size()[0]):
            root.grid_columnconfigure(i, weight=1)
        for i in range(root.grid_size()[1]):
            root.grid_rowconfigure(i, weight=1)

    def show_bruteforce_text(self):
        self.text_label.config(text="Text for Brute Force")

    def show_bnb_text(self):
        self.text_label.config(text="Text for Branch and Bound")

# Create the root window
root = Tk()

# Create an instance of the TransportPlanning class
app = TransportPlanning(root)

# Run the application
root.mainloop()
