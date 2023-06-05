class Store:
    def __init__(self, index, x, y, delivery):
        self.index = index
        self.x = x
        self.y = y
        self.delivery = delivery

    def __str__(self):
        return f"Index: {self.index}, X: {self.x}, Y: {self.y}, Entregas: {self.delivery}"
