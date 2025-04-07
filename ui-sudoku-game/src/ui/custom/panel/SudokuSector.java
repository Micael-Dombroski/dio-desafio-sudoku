package ui.custom.panel;

//import jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyle;
import ui.custom.input.NumberText;

import javax.sound.sampled.Line;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.Dimension;
import java.util.List;

import static java.awt.Color.black;

public class SudokuSector extends JPanel {
    public SudokuSector(final List<NumberText> textFields) {
        var dimension = new Dimension(170, 170);
        this.setSize(dimension);
        this.setPreferredSize(dimension);
        this.setBorder(new LineBorder(black, 2, true));
        this.setVisible(true);
        textFields.forEach(this::add);
    }
}
