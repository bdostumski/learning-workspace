package gui.commands;

import com.telerikacademy.wim.commands.contracts.Command;
import com.telerikacademy.wim.commands.creation.CreateMemberCommand;
import com.telerikacademy.wim.commands.creation.CreateTeamCommand;
import com.telerikacademy.wim.controllers.contracts.MembersController;
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

public class CreateTeamGui extends JFrame implements ActionListener {

    private CommandExecutor executor;
    private WimFactory factory;
    private TeamsController teamsController;
    private Command command;
    private List<String> list;

    private static JPanel panel;
    private static JFrame frame;
    private static JLabel label;
    JTextField teamName;
    JButton btnOk;
    JButton btnCancel;

    public CreateTeamGui(TeamsController teamsController) {
        this.teamsController = teamsController;

        executor = new CommandExecutor();
        factory = new WimFactoryImpl();
        command = new CreateTeamCommand(teamsController, factory);
        list = new ArrayList<>();

        panel = new JPanel();
        panel.setLayout(null);

        frame = new JFrame(CREATE_TEAM_WIM);
        frame.add(panel, BorderLayout.CENTER);
        frame.setLocation(200,200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        label = new JLabel(TEAM_NAME);
        label.setBounds(10, 20, 110, 25);
        label.setVerticalAlignment(SwingConstants.TOP);
        panel.add(label);

        teamName = new JTextField();
        teamName.setBounds(200, 20, 200, 25);
        panel.add(teamName);

        btnOk = new JButton(OK);
        btnOk.setBounds(10, 80, 110, 25);
        panel.add(btnOk);

        btnCancel = new JButton(CANCEL);
        btnCancel.setBounds(200, 80, 110, 25);
        panel.add(btnCancel);

        frame.setSize(450, 200);

        btnOk.addActionListener(this);
        btnCancel.addActionListener(this);

        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String choise = event.getActionCommand();
        switch (choise) {
            case CANCEL: {
                frame.setVisible(false);
            }
            break;
            case OK: {
                String name = teamName.getText();
                System.out.println(name);
                list.add(name);
                command = executor.createTeam(teamsController, factory);
                command.execute(list);
            }
            break;
        }
    }

}
