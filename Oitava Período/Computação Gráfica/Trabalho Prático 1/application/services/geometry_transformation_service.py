from typing import Union

from domain.entities.point import Point


class GeometryTransformation:

    def __init__(self):
        self.geometry_algorithm = {
            'translation': GeometryTransformation.translation,
            'rotation': '',
            'scale': GeometryTransformation.scale,
            'reflexion': ''
        }

    @staticmethod
    def algorithm_list() -> Union[tuple[str, str, str, str], str]:
        return 'translation', 'rotation', 'scale', 'reflexion'

    def choose_algorithm(self, algorithm: str):
        return self.geometry_algorithm[algorithm]

    @staticmethod
    def translation(points: list[Point], params) -> list[Point]:
        translation_factor_x = params[0]
        translation_factor_y = params[1]
        for point in points:
            point.x += translation_factor_x
            point.y += translation_factor_y
        return points

    @staticmethod
    def scale(points: list[Point], params) -> list[Point]:
        translation_factor_x = params[0]
        translation_factor_y = params[1]
        for point in points:
            point.x *= translation_factor_x
            point.y *= translation_factor_y
        return points