from typing import Union

class PaintService:

    def __init__(self):
        pass

    @staticmethod
    def algorithm_list(name: str) -> Union[tuple[str, str], str]:
        if name == 'line':
            return 'Bresenham', 'DDA'
        elif name == 'circle':
            return 'Bresenham'
        return ''