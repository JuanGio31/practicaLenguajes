package org.example.frontend;

import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.text.*;

/**
 * Clase que sirve para obtener la numeracion de las filas de un textPane
 *
 * @author giovanic
 */
public class NumberedEditorKit extends StyledEditorKit {

    @Override
    public ViewFactory getViewFactory() {
        return new NumberedViewFactory();
    }
}

class NumberedViewFactory implements ViewFactory {

    @Override
    public View create(Element elem) {
        String kind = elem.getName();
        if (kind != null) {
            switch (kind) {
                case AbstractDocument.ContentElementName -> {
                    return new LabelView(elem);
                }
                case AbstractDocument.ParagraphElementName -> {
                    //              return new ParagraphView(elem);
                    return new NumberedParagraphView(elem);
                }
                case AbstractDocument.SectionElementName -> {
                    return new BoxView(elem, View.Y_AXIS);
                }
                case StyleConstants.ComponentElementName -> {
                    return new ComponentView(elem);
                }
                case StyleConstants.IconElementName -> {
                    return new IconView(elem);
                }
                default -> {
                }
            }
        }
        // default to text display
        return new LabelView(elem);
    }
}

final class NumberedParagraphView extends ParagraphView {

    public static short NUMBERS_WIDTH = 32;

    public NumberedParagraphView(Element e) {
        super(e);
        short top = 0;
        short left = 0;
        short bottom = 0;
        short right = 0;
        this.setInsets(top, left, bottom, right);
    }

    @Override
    protected void setInsets(short top, short left, short bottom,
            short right) {
        super.setInsets(top, (short) (left + NUMBERS_WIDTH),
                bottom, right);
    }

    @Override
    public void paintChild(Graphics g, Rectangle r, int n) {
        super.paintChild(g, r, n);
        int previousLineCount = getPreviousLineCount();
        int numberX = r.x - getLeftInset();
        int numberY = r.y + r.height - 5;
        g.drawString(Integer.toString(previousLineCount + n + 1),
                numberX, numberY);
    }

    public int getPreviousLineCount() {
        int lineCount = 0;
        View parent = this.getParent();
        int count = parent.getViewCount();
        for (int i = 0; i < count; i++) {
            if (parent.getView(i) == this) {
                break;
            } else {
                lineCount += parent.getView(i).getViewCount();
            }
        }
        return lineCount;
    }
}
