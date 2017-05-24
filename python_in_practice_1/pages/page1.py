import os

#sys모듈은 파이썬 인터프리터와 관련된 정보와 기능을 제공하는 모듈
import sys
import tempfile



def main():
    if len(sys.argv) > 1 and sys.argv[1] == "-p":
        create_diagram(DiagramFactory).save(sys.stdout)
        create_diagram(SvgDiagramFactory).save(sys.stdout)
        return
    textFilename = os.path.join(tempfile.gettempdir(),"diagram.txt")
    svgFilename = os.path.join(tempfile.gettempdir(),"diagram.svg")




def create_diagram(factory):
    diagram = factory.make_diagram(30,7)
    rectangle = factory.make_rectangle(4,1,22,5,"yellow")
    text = factory.make_text(7,3,"Abstract Factory")
    diagram.add(rectangle)
    diagram.add(text)
    return diagram

class DiagramFactory:

    @classmethod
    def make_diagram(Class, width, height):
        return Class.Diagram(width, height)

    @classmethod
    def make_rectangle(Class, x, y, width, height, fill="white", stroke="black"):
        return Class.Rectangle(x, y, width, height, fill, stroke)

    @classmethod
    def make_text(Class, x, y, text, fontsize=12):
        return Class.Text(x, y, text, fontsize)


    BLANK = " "
    CORNER = "+"
    HORIZONTAL = "-"
    VERTICAL = "|"

    class Diagram:

        def __init__(self,width,height):
            self.width = width
            self.height = height
            self.diagram = DiagramFactory._create_rectangle(self.width, self.height, DiagramFactory.BLANK)


        def add(self,componet):
            for y, row in enumerate(componet.rows):
                for x, char in enumerate(row):
                    self.diagram[y + componet.y][x+componet.x] = char

        def save(self, filenameOrFile):
            file = (None if isinstance(filenameOrFile, str) else
                    filenameOrFile)
            try:
                if file is None:
                    file = open(filenameOrFile, "w", encoding="utf-8")
                for row in self.diagram:
                    print("".join(row), file==file)

            finally:
                if isinstance(filenameOrFile, str) and file is not None:
                    file.close()



    class Rectangle:

        def __init__(self, x, y, width, height, fill, stroke):
            self.x = x
            self.y = y
            self.rows = DiagramFactory._create_rectangle(width, height, DiagramFactory.BLANK if fill == "white" else "%")

    class Text:

        def __init__(self, x, y, text, fontsize):
            self.x = x
            self.y = y
            self.rows = [list(text)]


    def _create_rectangle(width, height, fill):
        rows = [[fill for _ in range(width)] for _ in range(height)]
        for x in range(1, width -1):
            rows[0][x] = DiagramFactory.HORIZONTAL
            rows[height -1][x] = DiagramFactory.HORIZONTAL

        for y in range(1, height -1):
            rows[y][0] = DiagramFactory.VERTICAL
            rows[y][width -1 ] = DiagramFactory.VERTICAL

        for y, x in ((0,0), (0, width - 1), (height - 1, 0),
                     (height -1, width -1)):
            rows[y][x] = DiagramFactory.CORNER

        return rows



















