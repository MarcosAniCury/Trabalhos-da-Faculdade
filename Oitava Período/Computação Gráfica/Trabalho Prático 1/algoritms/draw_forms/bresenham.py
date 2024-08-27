from ..utils.utils_pixels import set_pixel

class Bresenham:

    def __init__(self):
        self.x = 0
        self.y = 0
        self.x_temp = 0
        self.y_temp = 0

    def line(self, x1, y1, x2, y2):
        dx = x2 - x1
        dy = y2 - y1

        self.x_temp = 1 if dx > 0 else -1
        self.y_temp = 1 if dy > 0 else -1

        dx = abs(dx)
        dy = abs(dy)

        self.x = x1
        self.y = y1

        set_pixel(x, y)

        if dx > dy:
            self.set_pixels_line(dy, dx)

        else:
            self.set_pixels_line(dx, dy)

    def set_pixels_line(self, point1, point2):
        p = 2 * point1 - point2
        c1 = 2 * point1
        c2 = 2 * (point1 - point2)

        for _ in range(point2):
            self.y += self.y_temp
            if p < 0:
                p += c1
            else:
                p += c2
                self.x += self.x_temp
            set_pixel(x, y)

    def circle(self, xc, yc, raio):
        self.x = 0
        self.y = raio
        p = 3 - 2 * raio

        self.plot_symmetric_points(self.x, self.y, xc, yc)

        while self.x < self.y:
            if p < 0:
                p += 4 * self.x + 6
            else:
                p += 4 * (self.x - self.y) + 10
                self.y -= 1
            self.x += 1
            self.plot_symmetric_points(self.x, self.y, xc, yc)

    def plot_symmetric_points(self, a, b, xc, yc):
        set_pixel(a + xc, b + yc)
        set_pixel(a + xc, -b + yc)
        set_pixel(-a + xc, b + yc)
        set_pixel(-a + xc, -b + yc)
        set_pixel(b + xc, a + yc)
        set_pixel(b + xc, -a + yc)
        set_pixel(-b + xc, a + yc)
        set_pixel(-b + xc, -a + yc)