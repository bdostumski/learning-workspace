package gui;

import com.telerikacademy.wim.commands.ExitCommand;
import com.telerikacademy.wim.controllers.contracts.MembersController;
import com.telerikacademy.wim.controllers.contracts.TeamsController;
import com.telerikacademy.wim.controllers.contracts.WorkItemsController;
import gui.components.CreateLabels;
import gui.components.MainMenuImpl;
import gui.components.contracts.MainMenu;
import javax.swing.*;
import java.awt.*;

public class MainGui extends JFrame {

    private static final String MAIN_WINDOW_LABEL = "<html>" +
                    "<p style='text-align: center; font-weight: bold;'>" +
                    "Work Item Management (WIM)<br><br>" +
                    "CREATED BY<br><br>" +
                    "Dimitar Milkin & Borislav Dostumski</p>" +
                    "</html>";

    private JScrollPane jScrollPane = new JScrollPane();
    private static JLabel label = new JLabel(MAIN_WINDOW_LABEL);

    public MainGui(WorkItemsController workItemsController,
                   TeamsController teamsController,
                   MembersController membersController,
                   ExitCommand exitCommand) {

        JFrame frame = new JFrame("Work Item Management (WIM)");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Serif", Font.PLAIN, 18));
        frame.add(label);
        frame.pack();
        frame.setLocation(100, 100);
        MainMenu menu = new MainMenuImpl(workItemsController, teamsController, membersController, exitCommand);
        frame.setJMenuBar(menu.getMenuBar());
        frame.setSize(500, 300);
        frame.setVisible(true);
    }

}
