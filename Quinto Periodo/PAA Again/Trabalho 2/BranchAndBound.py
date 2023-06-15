from itertools import permutations
from Utils import read_arquive, copy_route, calc_distance, calc_fuel_used
import sys


# Global vars initialize
routes = {}
stores = {}
max_truck_payload = 0
current_combination_index = -1
matrix = None
lowest_route_consume_fuel = {
    "route_index": -1,
    "fuel_used": sys.maxsize
}


def is_route_discarded():
    global current_combination_index, routes, lowest_route_consume_fuel
    if lowest_route_consume_fuel["fuel_used"] < routes[current_combination_index]["fuel_used"]:
        return True
    return False


def discarded_current_route():
    global current_combination_index, routes
    routes[current_combination_index] = {
        "route": [],
        "fuel_used": 0
    }
    current_combination_index -= 1


def append_in_route(store, payload=0):
    global current_combination_index, routes
    # Adicionar uma nova loja a rota
    index_before_store = len(
        routes[current_combination_index]["route"]) - 1

    # Verifica se não é a primeira loja da rota
    if index_before_store >= 0:
        before_store = routes[current_combination_index]["route"][index_before_store]

        # Adicionar o gasto de combustivel para a nova loja
        routes[current_combination_index]["fuel_used"] += calc_fuel_used(
            calc_distance(before_store, store), payload)

    routes[current_combination_index]["route"].append(store)

# Finaliza a rota atual


def finish_route():
    global current_combination_index, matrix, routes, lowest_route_consume_fuel
    # Caso exista uma próxima rota quer dizer que ela foi cancelada logo, não deve inserir a matrix novamente pois a rota atual já foi finalizada
    if not current_combination_index + 1 in routes:
        # Finalizar rota atual com a matrix
        append_in_route(matrix)

        # Verifica se a rota deve ser descartada após a inclusão da matrix
        route_discarded = is_route_discarded()
        if not route_discarded:
            # Adicionar rota como a de menor custo, pois chegou até o final
            lowest_route_consume_fuel["route_index"] = current_combination_index
            lowest_route_consume_fuel["fuel_used"] = routes[current_combination_index]["fuel_used"]
        else:
            discarded_current_route()


def create_new_route(route_this_moment):
    global current_combination_index, matrix, routes, lowest_route_consume_fuel

    finish_route()

    # Criar uma nova rota
    current_combination_index += 1
    routes[current_combination_index] = copy_route(route_this_moment)


def find_stores_have_to_visit(stores_iteration):
    global current_combination_index, routes
    stores_have_to_visit = []
    have_visit = True
    for store in stores_iteration.values():
        # Se a loja ainda possuir entregas, deve visitar
        if len(store.delivery) > 0:
            stores_have_to_visit.append(store)
            continue

        # Verifica se a loja já foi visitada, caso não deve visitar
        have_visit = True
        for store_route in routes[current_combination_index]["route"]:
            if store_route.index == store.index:
                have_visit = False
                break

        if have_visit:
            stores_have_to_visit.append(store)

    return stores_have_to_visit


def generate_route(stores_iteration, initial_store, truck_next_store):
    global routes, stores, max_truck_payload, current_combination_index

    # Adicionar loja atual na rota e verifica se a rota deve ser podada
    append_in_route(initial_store, len(truck_next_store))

    # Verifica se o rota não foi descartada para continuar o código
    route_discarded = is_route_discarded()
    if not route_discarded:
        # Para continuar a nova rota a partir da onde essa parou
        route_this_moment = copy_route(routes[current_combination_index])

        # Verificar se a loja atual possui a lista "delivery"
        if len(initial_store.delivery) > 0 or len(truck_next_store) > 0:
            # Achar proxima loja a ser visitada na rota
            for i in range(1, max_truck_payload+1):
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
            # Gerar combinacoes possíveis com todas as lojas faltantes
            stores_have_to_visit = find_stores_have_to_visit(stores_iteration)
            for index, target_store in enumerate(stores_have_to_visit):
                # Gera variações da rota baseado em cada loop (caso não seja o primeiro loop)
                if index != 0:
                    create_new_route(route_this_moment)

                generate_route(stores_iteration, target_store, [])
    else:
        discarded_current_route()


def branch_and_bound(k_units_max):
    # Variaveis globais
    global routes, stores, max_truck_payload, current_combination_index, matrix, lowest_route_consume_fuel

    # Reset variáveis
    routes = {}
    stores = {}
    max_truck_payload = 0
    current_combination_index = -1
    matrix = None
    lowest_route_consume_fuel = {
        "route_index": -1,
        "fuel_used": sys.maxsize
    }

    max_truck_payload = k_units_max

    # Ler arquivo e preencher stores
    stores = read_arquive("stores.txt")

    # Remover matrix da lista para adiciona em cada rota no inicio e no fim
    matrix = stores.pop(0)

    # Inicia o loop para calculo de rota e consumo de combustivel
    for store in stores.values():
        # Inicializa as variáveis
        current_combination_index += 1
        routes[current_combination_index] = {
            "route": [],
            "fuel_used": 0
        }
        # Inicializa a rota com a matriz
        append_in_route(matrix)
        copied_stores = {key: store.copy()
                         for key, store in stores.items()}
        # Inicia a função recursiva
        generate_route(copied_stores, store, [])

        finish_route()

    return routes
