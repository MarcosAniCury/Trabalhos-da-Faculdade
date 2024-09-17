from typing import Callable
from domain.entities.point import Point


class Shape:

    @staticmethod
    def draw(self, algorithm: Callable[[Point, Point], list[Point]], first_point: Point, second_point: Point) -> list[Point]:
        pass

    @staticmethod
    def execute_geometry_transformation(self, algorithm: Callable[[list[Point]], list[Point]]) -> list[Point]:
        pass