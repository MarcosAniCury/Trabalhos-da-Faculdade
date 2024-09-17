from typing import Callable
from numbers import Number
from domain.entities.point import Point
from domain.entities.shape import Shape
from domain.services.circle_services import CircleServices


class Circle(Shape):

    def __init__(self) -> None:
        self.points_collection: list[Point] = []


    def draw(self, algorithm: Callable[[Point, Number], list[Point]], point_center: Point, second_point: Point) -> list[Point]:
        radius = CircleServices.calculate_radius(point_center, second_point)
        self.points_collection = algorithm(point_center, radius)
        return self.points_collection

    def execute_geometry_transformation(self, algorithm: Callable[[list[Point]], list[Point]], params) -> list[Point]:
        self.points_collection = algorithm(self.points_collection, params)
        return self.points_collection