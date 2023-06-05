class Loja:
    def __init__(self, index, x, y, entregas):
        self.index = index
        self.x = x
        self.y = y
        self.entregas = entregas

    def __str__(self):
        return f"{self.index} + {self.x} + {self.y} + {self.entregas}"