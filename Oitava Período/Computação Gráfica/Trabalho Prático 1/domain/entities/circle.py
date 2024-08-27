from typing import Callable
from numbers import Number
from point import Point

class Circle:

    def __init__(self) -> None:
        self.points_collection: list[Point] = []

    def draw(self, algorithm: Callable[[Point, Number], list[Point]], point_center: Point, radius: Number) -> None:
        self.points_collection = algorithm(point_center, radius)