from BruteForce import brute_force
from BranchAndBound import branch_and_bound
from Utils import find_low_cost_route, print_route
import time

k_units_max = int(
    input("Digite o máximo de unidades que o caminhão pode carregar: "))

start_time_brute_force = time.time()

routes_brute_force = brute_force(k_units_max)
find_low_cost_route(routes_brute_force)

end_time_brute_force = time.time()
execution_time_brute_force = end_time_brute_force - start_time_brute_force
print(f"\nTempo de execução: {execution_time_brute_force} segundos")


print("\n\n\n\n")


start_time_branch_and_bound = time.time()

routes_branch_and_bound = branch_and_bound(k_units_max)
index_route_low_cost = len(routes_branch_and_bound) - 2
# Caso a rota esteja menor que zero nenhuma rota foi gerada pois nenhuma loja tinha entregas
if index_route_low_cost >= 0:
    print_route(
        routes_branch_and_bound[index_route_low_cost], index_route_low_cost)
else:
    print({})

end_time_branch_and_bound = time.time()
execution_time_branch_and_bound = end_time_branch_and_bound - \
    start_time_branch_and_bound
print(f"\nTempo de execução: {execution_time_branch_and_bound} segundos")
