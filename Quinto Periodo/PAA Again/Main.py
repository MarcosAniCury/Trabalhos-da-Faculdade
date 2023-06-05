# from Store import Store

# def read_arquive():
#     global stores
#     arquive = open("stores.txt", "r")
#     lines = arquive.readlines()
#     for line in lines:
#         items = line.strip().split(" ")
#         listDelivery = []
#         if len(items) > 3:
#             listDelivery = items[3:]

#         stores[items[0]] = Store(items[0], items[1], items[2], listDelivery) 

# def visit_store(actual_store, store_to_visit, km_used):
#     global max_km
#     for store_visit in store_to_visit.values():
#         if len(store_visit.delivery) > 0:
#             calc_km = abs(actual_store.x - store_visit.x) + abs(actual_store.y - store_visit.y) / max_km
#             visit_store(store_visit.delivery, km_used + calc_km)

# # Define vars used in code
# max_km = 10

# k_units_max = input("Digite o máximo de unidades que o caminhão pode carregar: ")

# stores = {}

# read_arquive()

# where_truck = [0]

# stores_not_visit = stores[1:]
# for store_not_reach in stores_not_visit.values():
#     if len(store_not_reach.delivery) == 0:
#         continue

#     km_used = visit_store(store_not_reach, store_not_reach.delivery, 0)

import itertools
import matplotlib.pyplot as plt
from Store import Store

class Store:
    def __init__(self, index, x, y, delivery):
        self.index = index
        self.x = x
        self.y = y
        self.delivery = delivery

    def __str__(self):
        return f"Index: {self.index}, X: {self.x}, Y: {self.y}, Entregas: {self.delivery}"

def calcular_distancia(p1, p2):
    return ((p2.x - p1.x) ** 2 + (p2.y - p1.y) ** 2) ** 0.5

def calcular_combustivel(distancia, carga):
    rendimento = 10 - carga * 0.5
    return distancia / rendimento

def encontrar_menor_rota(lojas, capacidade):
    lojas = lojas.copy()
    matriz = lojas.pop(0)
    n = len(lojas)
    menor_combustivel = float('inf')
    menor_rota = None

    for permutacao in itertools.permutations(lojas):
        caminho = [matriz] + list(permutacao) + [matriz]
        carga = 0
        combustivel = 0

        for i in range(n):
            origem = caminho[i]
            destino = caminho[i + 1]
            distancia = calcular_distancia(origem, destino)
            combustivel += calcular_combustivel(distancia, carga)
            carga -= 1

            if destino.delivery:
                carga += 1

            if carga > capacidade:
                combustivel = float('inf')
                break

        if combustivel < menor_combustivel:
            menor_combustivel = combustivel
            menor_rota = caminho

    return menor_rota, menor_combustivel

def plotar_rota(lojas, rota):
    x = [lojas[i].x for i in rota]
    y = [lojas[i].y for i in rota]

    plt.plot(x, y, marker='o')
    plt.scatter(x[1:-1], y[1:-1], color='red', marker='s')
    plt.scatter(x[0], y[0], color='green', marker='s', label='Matriz')
    plt.xlabel('Coordenada X')
    plt.ylabel('Coordenada Y')
    plt.title('Rota do caminhão')
    plt.legend()
    plt.grid(True)
    plt.show()

def main():
    with open('lojas.txt', 'r') as file:
        lines = file.readlines()
        lojas = []
        for line in lines:
            data = line.strip().split()
            index, x, y, *delivery = map(int, data)
            lojas.append(Store(index, x, y, delivery))

    capacidade = 3  # Definir a capacidade máxima do caminhão

    menor_rota, menor_combustivel = encontrar_menor_rota(lojas, capacidade)

    print('Menor rota encontrada:')
    for store in menor_rota:
        print(str(store))
    # print(f'Menor quantidade de combustível gasta: {menor_combustivel}')

    plotar_rota(lojas, menor_rota)

if __name__ == '__main__':
    main()





