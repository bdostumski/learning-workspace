package gui.commands;

import com.telerikacademy.wim.commands.changes.CreateBoardInTeam;
import com.telerikacademy.wim.commands.changes.CreateBugInquiryInBoard;
import com.telerikacademy.wim.commands.contracts.Command;
import com.telerikacademy.wim.controllers.contracts.TeamsController;
import com.telerikacademy.wim.controllers.contracts.WorkItemsController;
import com.telerikacademy.wim.core.contracts.WimFactory;
import com.telerikacademy.wim.core.factories.CommandExecutor;
import com.telerikacademy.wim.core.factories.WimFactoryImpl;
import com.telerikacademy.wim.models.items.contracts.WorkingItems;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import static gui.common.ConstantsGui.*;

public class CreateBugGui extends JFrame implements ActionListener {

    private CommandExecutor executor;
    private WimFactory factory;
    private WorkItemsController workItemsController;
    private TeamsController teamsController;
    private Command command;
    private List<String> list;

    private static JPanel panel;

    private static JFrame frame;

    private static JLabel label1;
    private static JLabel label2;
    private static JLabel label3;
    private static JLabel label4;
    private static JLabel label5;
    private static JLabel label6;

    String[] strPriority = {HIGH, MEDIUM, LOW};
    String[] strSeverity = {CRITICAL, MAJOR, MINOR};

    JComboBox comboBox1;
    JComboBox comboBox2;

    JTextField teamName;
    JTextField boardName;
    JTextField bugTitle;
    JTextField bugDescription;

    JButton btnOk;
    JButton btnCancel;

    public CreateBugGui(TeamsController teamsController, WorkItemsController workItemsController) {
        this.teamsController = teamsController;
        this.workItemsController = workItemsController;

        factory = new WimFactoryImpl();
        executor = new CommandExecutor();
        command = new CreateBugInquiryInBoard(teamsController, workItemsController, factory);
        list = new ArrayList<>();

        panel = new JPanel();
        panel.setLayout(null);

        frame = new JFrame(CREATE_NEW_BUG_WIM);
        frame.add(panel, BorderLayout.CENTER);
        frame.setLocation(200,200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        label1 = new JLabel(BOARD_NAME);
        label1.setBounds(10, 20, 150, 25);
        label1.setVerticalAlignment(SwingConstants.TOP);
        panel.add(label1);

        label2 = new JLabel(TEAM_NAME);
        label2.setBounds(10, 60, 150, 25);
        label2.setVerticalAlignment(SwingConstants.TOP);
        panel.add(label2);

        label3 = new JLabel(BUG_TITLE);
        label3.setBounds(10, 100, 150, 25);
        label3.setVerticalAlignment(SwingConstants.TOP);
        panel.add(label3);

        label4 = new JLabel(BUG_DESCRIPTION);
        label4.setBounds(10, 140, 150, 25);
        label4.setVerticalAlignment(SwingConstants.TOP);
        panel.add(label4);

        label5 = new JLabel(BUG_PRIORITY);
        label5.setBounds(10, 180, 150, 25);
        label5.setVerticalAlignment(SwingConstants.TOP);
        panel.add(label5);

        label6 = new JLabel(BUG_SEVERITY);
        label6.setBounds(10, 220, 150, 25);
        label6.setVerticalAlignment(SwingConstants.TOP);
        panel.add(label6);

        boardName = new JTextField();
        boardName.setBounds(200, 20, 200, 25);
        panel.add(boardName);

        teamName = new JTextField();
        teamName.setBounds(200, 60, 200, 25);
        panel.add(teamName);

        bugTitle = new JTextField();
        bugTitle.setBounds(200, 100, 200, 25);
        panel.add(bugTitle);

        bugDescription = new JTextField();
        bugDescription.setBounds(200, 140, 200, 25);
        panel.add(bugDescription);

        comboBox1 = new JComboBox(strPriority);
        comboBox2 = new JComboBox(strSeverity);
        comboBox1.setSelectedIndex(2);
        comboBox2.setSelectedIndex(2);
        comboBox1.setBounds(200, 180, 200, 25);
        comboBox2.setBounds(200,220, 200, 25);
        panel.add(comboBox1);
        panel.add(comboBox2);

        btnOk = new JButton(OK);
        btnOk.setBounds(10, 260, 110, 25);
        panel.add(btnOk);

        btnCancel = new JButton(CANCEL);
        btnCancel.setBounds(200, 260, 110, 25);
        panel.add(btnCancel);

        frame.setSize(450, 340);

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
                String str1 = teamName.getText();
                String str2 = boardName.getText();
                String str3 = bugTitle.getText();
                String str4 = bugDescription.getText();
                String str5 = comboBox1.getSelectedItem().toString();
                String str6 = comboBox2.getSelectedItem().toString();

                System.out.println(str1);
                System.out.println(str2);
                System.out.println(str3);
                System.out.println(str4);
                System.out.println(str5);
                System.out.println(str6);

                list.add(str1);
                list.add(str2);
                list.add(str3);
                list.add(str4);
                list.add(str5);
                list.add(str6);

                command = executor.createBug(teamsController, workItemsController, factory);
                command.execute(list);
            }
            break;
        }
    }

}
