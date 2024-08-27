from ..utils.utils_pixels import set_pixel

def DDA(x1, y1, x2, y2):
    dx = x2 - x1
    dy = y2 - y1

    if abs(dx) > abs(dy):
        steps = abs(dx)
    else:
        steps = abs(dy)

    x_temp = dx / steps
    y_temp = dy / steps

    x = x1
    y = y1

    set_pixel(round(x), round(y))

    for k in range(1, steps + 1):
        x += x_temp
        y += y_temp
        set_pixel(round(x), round(y))
