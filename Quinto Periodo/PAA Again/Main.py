from Loja import Loja

def read_arquive():
    global lojas
    arquivo = open("lojas.txt", "r")
    linhas = arquivo.readlines()
    for linha in linhas:
        items = linha.strip().split(" ")
        listaEntregas = []
        if len(items) > 3:
            listaEntregas = items[3:]

        lojas[items[0]] = Loja(items[0], items[1], items[2], listaEntregas) 

k_unidades_max = input("Digite o máximo de unidades que o caminhão pode carregar: ")

lojas = {}

read_arquive()





