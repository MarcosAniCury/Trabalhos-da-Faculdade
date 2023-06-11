from Store import Store
import os
import sys


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
    print(f"Route:{index}")
    for store in route["route"]:
        print(str(store))
    print(f"Fuel used: {route['fuel_used']}")


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
        print_route(route_low_cost, index_route_low_cost)
    else:
        print(routes)


def copy_route(route):
    # Cria uma copia de route
    return {
        "route": route["route"].copy(),
        "fuel_used": route["fuel_used"]
    }
