class ColenSutherlandService:

    def __init__(self) -> None:
        pass

    #TODO: Configurar corretamente a função pois ta toda errada
    def clipping(self):
        # Se tem algo para "plotar"
        aceite = False
        # Se terminou cálculos
        feito = False

        def gera_codigo(x, y):
            # Função que gera código, você precisa implementar de acordo com sua necessidade
            pass

        def verifica_bit(cfora, bit):
            # Função para verificar o bit, você precisa implementar de acordo com sua necessidade
            pass

        # Exemplo de valores iniciais
        x1, y1 = 0, 0
        x2, y2 = 10, 10
        xmin, xmax = 2, 8
        ymin, ymax = 2, 8

        while not feito:  # recalcula
            c1 = gera_codigo(x1, y1)
            c2 = gera_codigo(x2, y2)

            if c1 == 0 and c2 == 0:
                aceite = True
                feito = True
            elif c1 & c2 != 0:
                feito = True
            else:  # calcula
                if c1 != 0:
                    cfora = c1
                else:
                    cfora = c2

                if verifica_bit(cfora, 0):
                    xint = xmin
                    yint = y1 + (y2 - y1) * (xmin - x1) / (x2 - x1)
                elif verifica_bit(cfora, 1):
                    xint = xmax
                    yint = y1 + (y2 - y1) * (xmax - x1) / (x2 - x1)
                elif verifica_bit(cfora, 2):
                    yint = ymin
                    xint = x1 + (x2 - x1) * (ymin - y1) / (y2 - y1)
                elif verifica_bit(cfora, 3):
                    yint = ymax
                    xint = x1 + (x2 - x1) * (ymax - y1) / (y2 - y1)

                if cfora == c1:
                    x1 = xint
                    y1 = yint
                else:
                    x2 = xint
                    y2 = yint
