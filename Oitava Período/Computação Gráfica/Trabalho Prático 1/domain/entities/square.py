from domain.entities.point import Point
from typing import Callable


class Square:

    def __init__(self):
        self.points_collection: list[Point] = []

    def draw(self, algorithm: Callable[[Point, Point], list[Point]], start_point: Point, end_point: Point) -> list[Point]:
        self.points_collection = algorithm(start_point, end_point)
        return self.points_collection