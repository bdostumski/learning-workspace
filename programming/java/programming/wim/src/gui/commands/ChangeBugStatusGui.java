package gui.commands;

import com.telerikacademy.wim.commands.changes.ChangeBugSeverity;
import com.telerikacademy.wim.commands.changes.ChangeBugStatus;
import com.telerikacademy.wim.commands.contracts.Command;
import com.telerikacademy.wim.controllers.contracts.WorkItemsController;
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

public class ChangeBugStatusGui extends JFrame implements ActionListener {

    private CommandExecutor executor;
    private WimFactory factory;
    private WorkItemsController workItemsController;
    private Command command;
    private List<String> list;

    private static JPanel panel;

    private static JFrame frame;

    private static JLabel label1;
    private static JLabel label2;

    JTextField bugId;

    String[] strStatus = {ACTIVE, FIXED};
    JComboBox comboBox1;

    JButton btnOk;
    JButton btnCancel;

    public ChangeBugStatusGui(WorkItemsController workItemsController) {
        this.workItemsController = workItemsController;

        factory = new WimFactoryImpl();
        executor = new CommandExecutor();
        command = new ChangeBugStatus(workItemsController);
        list = new ArrayList<>();
        panel = new JPanel();
        panel.setLayout(null);

        panel = new JPanel();
        panel.setLayout(null);

        frame = new JFrame(CHANGE_BUG_STATUS_WIM);
        frame.add(panel, BorderLayout.CENTER);
        frame.setLocation(200,200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        label1 = new JLabel(BUG_ID);
        label1.setBounds(10, 20, 110, 25);
        label1.setVerticalAlignment(SwingConstants.TOP);
        panel.add(label1);

        label2 = new JLabel(NEW_STATUS);
        label2.setBounds(10, 60, 110, 25);
        label2.setVerticalAlignment(SwingConstants.TOP);
        panel.add(label2);

        bugId = new JTextField();
        bugId.setBounds(150, 20, 200, 25);
        panel.add(bugId);

        comboBox1 = new JComboBox(strStatus);
        comboBox1.setSelectedIndex(1);
        comboBox1.setBounds(150, 60, 200, 25);
        panel.add(comboBox1);

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
        String choise = event.getActionCommand();
        switch (choise) {
            case CANCEL: {
                frame.setVisible(false);
            }
            break;
            case OK: {
                String str1 = bugId.getText();
                String str2 = comboBox1.getSelectedItem().toString();
                System.out.println(str1);
                System.out.println(str2);

                list.add(str1);
                list.add(str2);

                command = executor.changeBugStatus(workItemsController);
                command.execute(list);
            }
            break;
        }
    }
}
