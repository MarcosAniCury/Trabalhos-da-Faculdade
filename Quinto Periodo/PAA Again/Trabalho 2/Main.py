from Store import Store
from itertools import permutations
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
    for store in route["route"]:
        print(str(store))
    print(f"Fuel used: {route['fuel_used']}")


def append_in_route(store, payload=0):
    global current_combination_index
    # Adicionar uma nova loja a rota
    index_before_store = len(
        routes[current_combination_index]["route"]) - 1

    if index_before_store >= 0:
        before_store = routes[current_combination_index]["route"][index_before_store]

        # Adicionar o gasto de combustivel para a nova loja
        routes[current_combination_index]["fuel_used"] += calc_fuel_used(
            calc_distance(before_store, store), payload)

    routes[current_combination_index]["route"].append(store)


def create_new_route(route_this_moment):
    global current_combination_index
    # Finalizar rota atual com a matriz
    append_in_route(matrix)

    # Criar uma nova rota
    current_combination_index += 1
    routes[current_combination_index] = copy_route(route_this_moment)


def copy_route(route):
    # Cria uma copia de route
    return {
        "route": route["route"].copy(),
        "fuel_used": route["fuel_used"]
    }


def generate_route(stores_iteration, initial_store, truck_next_store):
    global routes, stores, k_units_max, current_combination_index

    # Adicionar loja atual na rota
    append_in_route(initial_store, len(truck_next_store))

    # Verificar se a loja atual possui a lista "delivery"
    if len(initial_store.delivery) > 0 or len(truck_next_store) > 0:
        route_this_moment = copy_route(routes[current_combination_index])

        # Achar proxima loja a ser visitada na rota
        for i in range(1, k_units_max+1):
            # Rota total a ser percorrida
            truck_route_all = initial_store.delivery + truck_next_store
            # Caso o tamanho do array seja menor que i sair fora do loop para otimizar
            if len(truck_route_all) < i:
                break
            # Gera todas as combinações possíveis
            all_permutations_truck_and_delivery = list(
                permutations(truck_route_all, i))
            for permutation_index, permutation in enumerate(all_permutations_truck_and_delivery):
                for index, index_target_store in enumerate(permutation):
                    # Gera variações da rota baseado em cada loop (caso não seja o primeiro loop)
                    if not (i == 1 and permutation_index == 0 and index == 0):
                        create_new_route(route_this_moment)

                    # Criar um cópia das lojas que já foram visitas
                    copied_stores_iteration = {
                        key: store.copy() for key, store in stores_iteration.items()}

                    index_store_to_remove = initial_store.index
                    # Caso a loja já que estamos visitando seja uma entrega de uma loja antes da anterior, procurar a loja que possui esse entrega
                    if not index_target_store in copied_stores_iteration[index_store_to_remove].delivery:
                        for item in reversed(routes[current_combination_index]["route"]):
                            if index_target_store in item.delivery:
                                index_store_to_remove = item.index
                                break

                    # Remover a loja que estamos visitando agora
                    copied_stores_iteration[index_store_to_remove].remove_delivery_item(
                        index_target_store)

                    # Remove item das proximas lojas do caminhao
                    new_truck_next_store = [
                        item for item in permutation if not item == index_target_store]

                    generate_route(
                        copied_stores_iteration, copied_stores_iteration[index_target_store], new_truck_next_store)
    else:
        # Encontrar outra loja que tenha a lista "delivery"
        for store in stores_iteration.values():
            if len(store.delivery) > 0:
                generate_route(stores_iteration, store, [])
                break


# Input de maximo de items que o caminhão carrega
max_km = 10

k_units_max = int(
    input("Digite o máximo de unidades que o caminhão pode carregar: "))

stores = {}

# Ler arquivo e preencher stores
read_arquive()

routes = {}

matrix = stores.pop(0)

current_combination_index = -1

# Inicia o loop para calculo de rota e consumo de combustivel
for index, store in stores.items():
    # A primeira loja só pode ser selecionada se tiver entregas
    if len(store.delivery) > 0:
        # Inicializa as variáveis
        current_combination_index += 1
        routes[current_combination_index] = {
            "route": [],
            "fuel_used": 0
        }
        # Inicializa a rota com a matriz
        append_in_route(matrix)
        copied_stores = {key: store.copy() for key, store in stores.items()}
        # Inicia a função recursiva
        generate_route(copied_stores, store, [])
        # Finaliza a rota com a matriz
        append_in_route(matrix)

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
