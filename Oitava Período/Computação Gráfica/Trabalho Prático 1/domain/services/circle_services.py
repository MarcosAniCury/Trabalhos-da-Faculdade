import math
from ..entities.point import Point

class CircleServices:

    @staticmethod
    def calculate_radius(center_point: Point, border_point: Point) -> int:
        return int(math.sqrt((border_point.x - center_point.x) ** 2 + (border_point.y - center_point.y) ** 2))