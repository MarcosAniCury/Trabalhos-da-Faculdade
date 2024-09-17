from typing import Union
from domain.entities.circle import Circle
from domain.entities.line import Line


class ShapeCollection:

    def __init__(self) -> None:
        self.shapes: list[Union[Line, Circle]] = []

    def add_shape(self, shape: Union[Line, Circle]) -> None:
        self.shapes.append(shape)

    def execute_transformation(self, algorithm, params):
        for shape in self.shapes:
            shape.execute_geometry_transformation(algorithm, params)