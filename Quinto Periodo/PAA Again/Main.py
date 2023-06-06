from Store import Store

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

def calc_distance(p1, p2): #Using Euclidian calculation
    return ((p2.x - p1.x) ** 2 + (p2.y - p1.y) ** 2) ** 0.5

def calc_fuel_used(distance, payload):
    efficiency = 10 - payload * 0.5
    return distance / efficiency

def generate_route(stores_iteration, initial_store, max_weight, n_delivery_packages):
    global routes, stores, n_packages, current_combination_index
    # Adicionar loja atual à permutação
    routes[current_combination_index].append(initial_store)

    # Verificar se a loja atual possui a lista "delivery"
    if len(initial_store.delivery) > 0:
        # Gerar permutações com base na lista "delivery"
        for index, index_target_store in enumerate(initial_store.delivery):
            # Verificar se o caminhão consegue carregar o pacote
            if max_weight > 1:
                # Gera uma possível nova rota
                if index > 0 and n_delivery_packages < n_packages:
                    current_combination_index = current_combination_index + 1
                    routes[current_combination_index] = route_this_moment   
                else: 
                    route_this_moment = routes[current_combination_index].copy()

                # Atualizar o peso máximo
                new_wight = max_weight

                # Gerar permutações com a loja alvo
                copied_stores_iteration = {key: store.copy() for key, store in stores_iteration.items()}

                copied_stores_iteration[initial_store.index].remove_delivery_item(index_target_store)
                n_delivery_packages = n_delivery_packages + 1 
                
                generate_route(copied_stores_iteration, copied_stores_iteration[index_target_store], new_wight, n_delivery_packages)
    else:
        # Encontrar outra loja que tenha a lista "delivery"
        for store in stores_iteration.values():
            if len(store.delivery) > 0:
                generate_route(stores_iteration, store, max_weight, n_delivery_packages)
                break


# Define vars used in code
max_km = 10

k_units_max = int(input("Digite o máximo de unidades que o caminhão pode carregar: "))

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

for index,route in routes.items():
    print(f"Route:{index}")
    print(route)
    for store in route:
        print(str(store)+"\n")






