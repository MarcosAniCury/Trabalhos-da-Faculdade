from typing import Union
import math

from domain.entities.point import Point


class GeometryTransformation:

    def __init__(self):
        self.geometry_algorithm = {
            'translation': GeometryTransformation.translation,
            'rotation': GeometryTransformation.rotation,
            'scale': GeometryTransformation.scale,
            'reflexion': GeometryTransformation.reflexion
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
    def scale(points, params):
        x_center, y_center = GeometryTransformation.calc_center_point(points)

        points_scales = []
        for p in points:
            x_new = (p.x - x_center) * params[0] + x_center
            y_new = (p.y - y_center) * params[1] + y_center
            points_scales.append(Point(x_new, y_new))
        return points_scales

    @staticmethod
    def rotation(points, ang):
        x_center, y_center = GeometryTransformation.calc_center_point(points)

        ang_rad = math.radians(ang)

        new_points = []
        for p in points:
            new_x = x_center + (p.x - x_center) * math.cos(ang_rad) - (p.y - y_center) * math.sin(ang_rad)
            new_y = y_center + (p.x - x_center) * math.sin(ang_rad) + (p.y - y_center) * math.cos(ang_rad)
            new_points.append(Point(new_x, new_y))
        return new_points

    @staticmethod
    def reflexion(points, reflexion_choose_type):
        x_center, y_center = GeometryTransformation.calc_center_point(points)
        new_points = []
        for p in points:
            new_x = p.x
            new_y = p.y

            if reflexion_choose_type == 'x' or reflexion_choose_type == 'xy':
                new_x = 2 * x_center - p.x
            if reflexion_choose_type == 'y' or reflexion_choose_type == 'xy':
                new_y = 2 * y_center - p.y

            new_points.append(Point(new_x, new_y))
        return new_points

    @staticmethod
    def calc_center_point(points):
        x_total = sum([p.x for p in points])
        y_total = sum([p.y for p in points])
        x_center = x_total / len(points)
        y_center = y_total / len(points)
        return x_center, y_center
