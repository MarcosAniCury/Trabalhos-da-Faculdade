from ..entities.point import Point

class DDAService:

    @staticmethod
    def DDA(start_point: Point, end_point: Point) -> None:
        float_start_point = start_point.float_point()
        float_end_point = end_point.float_point()

        dx = float_end_point.y - float_start_point.x
        dy = float_end_point.y - float_start_point.y

        if abs(dx) > abs(dy):
            steps = abs(dx)
        else:
            steps = abs(dy)

        x_temp = dx / steps
        y_temp = dy / steps

        x = float_start_point.x
        y = float_start_point.y

        # set_pixel(round(x), round(y))

        for k in range(1, steps + 1):
            x += x_temp
            y += y_temp
            # set_pixel(round(x), round(y))
