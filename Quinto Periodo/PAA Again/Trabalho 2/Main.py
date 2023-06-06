from Store import Store
import sys


def read_arquive():
    global stores
    arquive = open("lojas.txt", "r")
    lines = arquive.readlines()
    for line in lines:
        items = [int(item) for item in line.strip().split(" ")]
        listDelivery = []
        if len(items) > 3:
            listDelivery = items[3:]

        stores[items[0]] = Store(items[0], items[1], items[2], listDelivery)


def calc_distance(p1, p2):  # Using Euclidian calculation
    return ((p2.x - p1.x) ** 2 + (p2.y - p1.y) ** 2) ** 0.5


def calc_fuel_used(distance, payload):
    efficiency = 10 - payload * 0.5
    return distance / efficiency

def print_route(route, index):
    print(f"Route:{index}")
    for store in route:
        print(str(store))

def generate_route(stores_iteration, initial_store, max_weight, n_delivery_packages):
    global routes, stores, n_packages, current_combination_index
    # Adicionar loja atual na rota
    routes[current_combination_index].append(initial_store)

    # Verificar se a loja atual possui a lista "delivery"
    if len(initial_store.delivery) > 0:
        # Achar proxima loja a ser visitada na rota
        for index, index_target_store in enumerate(initial_store.delivery):
            # MODIFICAR
            if max_weight > 1:
                # Gera variações da rota baseado em cada loop
                if index > 0:
                    current_combination_index = current_combination_index + 1
                    routes[current_combination_index] = route_this_moment
                else:
                    route_this_moment = routes[current_combination_index].copy(
                    )

                # MODIFICAR
                new_wight = max_weight

                # Criar um cópia das lojas que já foram visitas
                copied_stores_iteration = {
                    key: store.copy() for key, store in stores_iteration.items()}

                # Remover a loja que estamos visitando agora
                copied_stores_iteration[initial_store.index].remove_delivery_item(
                    index_target_store)
                n_delivery_packages = n_delivery_packages + 1

                generate_route(
                    copied_stores_iteration, copied_stores_iteration[index_target_store], new_wight, n_delivery_packages)
    else:
        # Encontrar outra loja que tenha a lista "delivery"
        for store in stores_iteration.values():
            if len(store.delivery) > 0:
                generate_route(stores_iteration, store,
                               max_weight, n_delivery_packages)
                break


# Define vars used in code
max_km = 10

k_units_max = int(
    input("Digite o máximo de unidades que o caminhão pode carregar: "))

stores = {}

read_arquive()

n_packages = sum(len(store.delivery) for store in stores.values())

routes = {}

matrix = stores.pop(0)

current_combination_index = -1

for store in stores.values():
    if len(store.delivery) > 0:
        current_combination_index = current_combination_index + 1
        routes[current_combination_index] = []
        copied_stores = {key: store.copy() for key, store in stores.items()}
        generate_route(copied_stores, store, k_units_max, 0)

# Caculo de custo de combustivel nas rotas
low_cost = sys.maxsize
route_low_cost = []
index_route_low_cost = 0

for index, route in routes.items():
    route_cost = 0
    before_store = matrix  # Matrix como ponto de inicio
    route.append(matrix)  # Matrix como ponto final
    for store in route:
        route_cost = route_cost + calc_fuel_used(calc_distance(before_store, store), 1)
        before_store = store
    if low_cost > route_cost:
        low_cost = route_cost
        route_low_cost = route
        index_route_low_cost = index
    route.insert(0, matrix)
    print_route(route, index)
    print("\n")

print(f"Rota com menor custo:")
print_route(route_low_cost, index_route_low_cost)
print(f"Custo da rota: {low_cost}")
