package gui.commands;

import com.telerikacademy.wim.commands.changes.CreateBoardInTeam;
import com.telerikacademy.wim.commands.contracts.Command;
import com.telerikacademy.wim.controllers.contracts.TeamsController;
import com.telerikacademy.wim.core.contracts.WimFactory;
import com.telerikacademy.wim.core.factories.CommandExecutor;
import com.telerikacademy.wim.core.factories.WimFactoryImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import static gui.common.ConstantsGui.*;

public class CreateNewBoardGui extends JFrame implements ActionListener {

    private CommandExecutor executor;
    private WimFactory factory;
    private TeamsController teamsController;
    private Command command;
    private List<String> list;

    private static JPanel panel;
    private static JFrame frame;
    private static JLabel label1;
    private static JLabel label2;

    JTextField teamName;
    JTextField boardName;
    JButton btnOk;
    JButton btnCancel;

    public CreateNewBoardGui(TeamsController teamsController) {
        this.teamsController = teamsController;

        executor = new CommandExecutor();
        factory = new WimFactoryImpl();
        command = new CreateBoardInTeam(teamsController, factory);
        list = new ArrayList<>();

        panel = new JPanel();
        panel.setLayout(null);

        frame = new JFrame(CREATE_NEW_BOARD_WIM);
        frame.add(panel, BorderLayout.CENTER);
        frame.setLocation(200,200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        label1 = new JLabel(BOARD_NAME);
        label1.setBounds(10, 20, 110, 25);
        label1.setVerticalAlignment(SwingConstants.TOP);
        panel.add(label1);

        label2 = new JLabel(TEAM_NAME);
        label2.setBounds(10, 60, 110, 25);
        label2.setVerticalAlignment(SwingConstants.TOP);
        panel.add(label2);

        boardName = new JTextField();
        boardName.setBounds(110, 20, 200, 25);
        panel.add(boardName);

        teamName = new JTextField();
        teamName.setBounds(110, 60, 200, 25);
        panel.add(teamName);

        btnOk = new JButton(OK);
        btnOk.setBounds(10, 120, 110, 25);
        panel.add(btnOk);

        btnCancel = new JButton(CANCEL);
        btnCancel.setBounds(200, 120, 110, 25);
        panel.add(btnCancel);

        frame.setSize(450, 200);

        btnOk.addActionListener(this);
        btnCancel.addActionListener(this);

        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String choice = event.getActionCommand();
        switch (choice) {
            case CANCEL: {
                frame.setVisible(false);
            }
            break;
            case OK: {
                String name1 = boardName.getText();
                String name2 = teamName.getText();
                System.out.println(name1);
                System.out.println(name2);

                list.add(name1);
                list.add(name2);
                command = executor.createNewBoard(teamsController, factory);
                command.execute(list);
            }
            break;
        }
    }

}
