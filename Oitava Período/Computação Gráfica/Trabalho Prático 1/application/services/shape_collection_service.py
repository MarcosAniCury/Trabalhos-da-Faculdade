from domain.entities.square import Square
from domain.services.bresenham_service import BresenhamService
from domain.services.colen_sutherland_service import ColenSutherlandService
from domain.services.digital_differential_analyzer_service import DDAService
from domain.entities.line import Line
from domain.entities.circle import Circle
from domain.entities.shape import Shape

class ShapeCollectionService:

    def __init__(self):
        colen_sutherland_service = ColenSutherlandService()
        bresenham_service = BresenhamService()
        dda_service = DDAService()

        self.shapes_algorithm = {
            'line': {
                'Bresenham': bresenham_service.line,
                'DDA': dda_service.DDA
            },
            'circle': {
                'Bresenham': bresenham_service.circle                                                                             ,
            },
            'clipping': {
                'ColenSutherland': colen_sutherland_service.clipping
            }
        }

        self.shapes = {
            'line': Line,
            'circle': Circle,
            'clipping': Square,
        }

    def choose_shape(self, shape_type: str) -> Shape:
        return self.shapes[shape_type]

    def choose_shape_algorithm(self, shape: str, algorithm: str):
        return self.shapes_algorithm[shape][algorithm]