from typing import Union
from circle import Circle
from line import Line

class ShapeCollection:

    def __init__(self) -> None:
        self.shapes: list[Union[Line, Circle]] = []

    def add_shape(self, shape: Union[Line, Circle]) -> None:
        self.shapes.append(shape)