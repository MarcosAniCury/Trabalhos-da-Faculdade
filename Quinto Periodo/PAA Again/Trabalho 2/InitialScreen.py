from tkinter import *
from tkinter import ttk
from BruteForce import brute_force
from BranchAndBound import branch_and_bound
from Utils import find_low_cost_route, print_route, copy_route
from AnimateGraph import animate_route
import time


class TransportPlanning:
    def __init__(self, root):
        self.routes = None

        self.root = root
        self.root.title("Planejamento de Transporte de carga")
        self.root.geometry("600x800")
        self.root.resizable(False, False)
        self.root.configure(background="white")

        title_label = Label(root, text="Planejamento de Transporte de carga", font=(
            "Arial", 16), bg="white")
        title_label.grid(row=0, column=0, columnspan=2, padx=10, pady=10)

        input_label = Label(root, text="Digite o máximo de unidades que o caminhão pode carregar:", font=(
            "Arial", 14), bg="white")
        input_label.grid(row=1, column=0, columnspan=2, padx=10, pady=5)

        self.input_entry = Entry(root, font=("Arial", 14))
        self.input_entry.grid(row=2, column=0, columnspan=2, padx=10, pady=5)

        bruteforce_button = Button(
            root, text="Força Bruta", width=15, height=2, command=self.show_bruteforce_text)
        bruteforce_button.grid(
            row=3, column=0, padx=(10, 5), pady=5, sticky="E")

        bnb_button = Button(root, text="Ramificar e limitar",
                            width=15, height=2, command=self.show_bnb_text)
        bnb_button.grid(row=3, column=1, padx=(5, 10), pady=5, sticky="W")

        self.text_label = Label(root, text="", font=("Arial", 14), bg="white")
        self.text_label.grid(row=4, column=0, columnspan=2, padx=10, pady=5)
        self.frame_switch = Frame(root, width=500, height=50)
        self.frame_switch.configure(background="white")
        self.frame_switch.grid(row=5, column=0, columnspan=2, pady=10)

        self.label_switch = Label(
            self.frame_switch, text="Rotas:", font=("Arial", 14), bg="white")
        self.label_switch.grid(row=0, column=0, padx=5, sticky="E")

        self.switch_var = StringVar(value="Empty")
        self.switch = ttk.Combobox(self.frame_switch, textvariable=self.switch_var, values=[
                                   "Empty"], state="readonly")
        self.switch.grid(row=0, column=1, padx=5, sticky="W")

        plot_button = Button(root, text="Plotar rota",
                             width=15, height=2, command=self.plot_graph)
        plot_button.grid(row=6, column=0, columnspan=2, padx=10, pady=5)

        # Centralizar os items
        for i in range(root.grid_size()[0]):
            root.grid_columnconfigure(i, weight=1)
        for i in range(root.grid_size()[1]):
            root.grid_rowconfigure(i, weight=1)

    def show_bruteforce_text(self):
        start_time_brute_force = time.time()

        # Gerar todas as rotas
        routes_brute_force = brute_force(int(self.input_entry.get()))
        # Achar rota de menor custo
        route_low_cost_text, index_route_low_cost = find_low_cost_route(
            routes_brute_force)

        end_time_brute_force = time.time()
        execution_time_brute_force = end_time_brute_force - start_time_brute_force
        route_low_cost_text += f"\n\nTempo de execução: {execution_time_brute_force} segundos"

        # Exibe texto da rota de menor custo na tela
        self.text_label.config(text=route_low_cost_text)

        # Configura rota com todas as rotas possíveis
        self.switch.config(values=list(routes_brute_force.keys()))
        self.switch.current(index_route_low_cost)

        # Setar rotas
        self.routes = routes_brute_force

    def show_bnb_text(self):
        start_time_brute_force = time.time()

        # Gerar todas as rotas
        routes_branch_and_bound = branch_and_bound(int(self.input_entry.get()))
        # Achar rota de menor custo
        index_route_low_cost = len(routes_branch_and_bound) - 2
        route_low_cost_text = None
        # Caso a rota esteja menor que zero nenhuma rota foi gerada pois nenhuma loja tinha entregas
        if index_route_low_cost >= 0:
            route_low_cost_text = print_route(
                routes_branch_and_bound[index_route_low_cost], index_route_low_cost)
        else:
            route_low_cost_text = ""

        end_time_brute_force = time.time()
        execution_time_brute_force = end_time_brute_force - start_time_brute_force
        route_low_cost_text += f"\n\nTempo de execução: {execution_time_brute_force} segundos"

        # Exibe texto da rota de menor custo na tela
        self.text_label.config(text=route_low_cost_text)

        list_routes_branch_and_bound = list(
            routes_branch_and_bound.keys())[:-1]
        # Configura rota com todas as rotas possíveis
        self.switch.config(values=list_routes_branch_and_bound)
        self.switch.current(index_route_low_cost)

        # Setar rotas
        self.routes = routes_branch_and_bound

    def plot_graph(self):
        # Inicia a animação com a rota selecionada
        animate_route(copy_route(self.routes[int(self.switch.get())]), int(
            self.input_entry.get()))


root = Tk()

app = TransportPlanning(root)

root.mainloop()
