from ..entities.point import Point

class BresenhamService:

    def __init__(self) -> None:
        self.x = 0
        self.y = 0
        self.x_temp = 0
        self.y_temp = 0

    def line(self, start_point: Point, end_point: Point) -> None:
        dx = end_point.x - start_point.x
        dy = end_point.y - start_point.y

        self.x_temp = 1 if dx > 0 else -1
        self.y_temp = 1 if dy > 0 else -1

        dx = abs(dx)
        dy = abs(dy)

        self.x = start_point.x
        self.y = start_point.y

        # set_pixel(x, y)

        if dx > dy:
            self.set_pixels_line(dy, dx)

        else:
            self.set_pixels_line(dx, dy)

    def set_pixels_line(self, point1: int, point2: int) -> None:
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
            # set_pixel(x, y)

    def circle(self, center_point: Point, raio: int) -> None:
        self.x = 0
        self.y = raio
        p = 3 - 2 * raio

        self.plot_symmetric_points(self.x, self.y, center_point)

        while self.x < self.y:
            if p < 0:
                p += 4 * self.x + 6
            else:
                p += 4 * (self.x - self.y) + 10
                self.y -= 1
            self.x += 1
            self.plot_symmetric_points(self.x, self.y, center_point)

    def plot_symmetric_points(self, a: int, b: int, center_point: Point) -> None:
        pass
        # set_pixel(a + center_point.x, b + center_point.y)
        # set_pixel(a + center_point.x, -b + center_point.y)
        # set_pixel(-a + center_point.x, b + center_point.y)
        # set_pixel(-a + center_point.x, -b + center_point.y)
        # set_pixel(b + center_point.x, a + center_point.y)
        # set_pixel(b + center_point.x, -a + center_point.y)
        # set_pixel(-b + center_point.x, a + center_point.y)
        # set_pixel(-b + center_point.x, -a + center_point.y)