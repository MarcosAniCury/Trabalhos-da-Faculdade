from typing import Self, Union


class Point:

    def __init__(self, x: Union[int, float], y: Union[int, float]) -> None:
        self.x = x
        self.y = y

    def float_point(self) -> Self:
        return Point(float(self.x), float(self.y))