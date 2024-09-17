from typing import Callable
from domain.entities.point import Point
from domain.entities.shape import Shape


class Line(Shape):

    def __init__(self) -> None:
        self.points_collection: list[Point] = []

    def draw(self, algorithm: Callable[[Point, Point], list[Point]], start_point: Point, end_point: Point) -> list[Point]:
        self.points_collection = algorithm(start_point, end_point)
        return self.points_collection

    def execute_geometry_transformation(self, algorithm: Callable[[list[Point]], list[Point]], params) -> list[Point]:
        self.points_collection = algorithm(self.points_collection, params)
        return self.points_collection