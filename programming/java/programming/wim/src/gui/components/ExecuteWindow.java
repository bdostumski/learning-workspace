package gui.components;

import javax.swing.*;

public class ExecuteWindow {

    private JScrollPane jScrollPane = new JScrollPane();

    public ExecuteWindow(String stringValue) {

        JFrame frame = new JFrame("Execute Window (WIM)");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JScrollPane scrollPane = new JScrollPane(new CreateLabels(stringValue));
        frame.add(scrollPane);
        frame.pack();
        frame.setLocation(200, 200);
        frame.setSize(1200, 300);
        frame.setVisible(true);
    }
}
