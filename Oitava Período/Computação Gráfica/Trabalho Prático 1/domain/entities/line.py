from typing import Callable
from point import Point

class Line:

    def __init__(self) -> None:
        self.points_collection = []

    def draw(self, algorithm: Callable[[Point, Point], list[Point]], start_point: Point, end_point: Point) -> None:
        self.points_collection = algorithm(start_point, end_point)