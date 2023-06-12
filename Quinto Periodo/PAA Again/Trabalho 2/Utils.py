from Store import Store
import os
import sys


def get_and_remove_first_items(array, x):
    first_items = []
    if array:
        for _ in range(min(x, len(array))):
            first_item = array.pop(0)
            first_items.append(first_item)
    return first_items


def read_arquive(arquive_name):
    stores = {}
    # Obtém o caminho absoluto do diretório do script em execução
    script_directory = os.path.dirname(os.path.abspath(sys.argv[0]))
    file_path = os.path.join(script_directory, arquive_name)
    arquive = open(file_path, "r")
    lines = arquive.readlines()
    for line in lines:
        items = [int(item) for item in line.strip().split(" ")]
        listDelivery = []
        if len(items) > 3:
            listDelivery = items[3:]

        stores[items[0]] = Store(items[0], items[1], items[2], listDelivery)
    return stores


def calc_distance(p1, p2):  # Using Euclidian calculation
    return ((p2.x - p1.x) ** 2 + (p2.y - p1.y) ** 2) ** 0.5


def calc_fuel_used(distance, payload):
    efficiency = 10 - payload * 0.5
    return distance / efficiency


def print_route(route, index):

    route_text = f"Route:{index}\n\n"
    for store in route["route"]:
        route_text += f"{str(store)}\n"
    route_text += f"Fuel used: {route['fuel_used']}"

    return route_text


def find_low_cost_route(routes):
    if len(routes) > 0:
        # Caculo de custo de combustivel nas rotas
        route_low_cost = {
            "fuel_used": sys.maxsize
        }
        index_route_low_cost = 0

        # Encontra a rota com o menor consumo de combustível
        for index, route in routes.items():
            if route_low_cost["fuel_used"] > route["fuel_used"]:
                route_low_cost = route
                index_route_low_cost = index
            print_route(route, index)
            print("\n")

        print(f"Rota com menor custo:")
        return print_route(route_low_cost, index_route_low_cost), index_route_low_cost
    else:
        return ""


def copy_route(route):
    # Cria uma copia de route
    return {
        "route": route["route"].copy(),
        "fuel_used": route["fuel_used"]
    }
