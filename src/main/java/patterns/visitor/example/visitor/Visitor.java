package patterns.visitor.example.visitor;

import patterns.visitor.example.shapes.Circle;
import patterns.visitor.example.shapes.CompoundShape;
import patterns.visitor.example.shapes.Dot;
import patterns.visitor.example.shapes.Rectangle;

public interface Visitor {
    String visitDot(Dot dot);

    String visitCircle(Circle circle);

    String visitRectangle(Rectangle rectangle);

    String visitCompoundGraphic(CompoundShape cg);
}
