package gui.commands;

import com.telerikacademy.wim.commands.changes.ChangeStoryPriority;
import com.telerikacademy.wim.commands.changes.ChangeStorySize;
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

public class ChangeStorySizeGui extends JFrame implements ActionListener {

    private CommandExecutor executor;
    private WimFactory factory;
    private WorkItemsController workItemsController;
    private Command command;
    private List<String> list;

    private static JPanel panel;

    private static JFrame frame;

    private static JLabel label1;
    private static JLabel label2;

    JTextField storyId;

    String[] strSize = {LARGE, MEDIUM, SMALL};
    JComboBox comboBox1;

    JButton btnOk;
    JButton btnCancel;

    public ChangeStorySizeGui(WorkItemsController workItemsController) {

        this.workItemsController = workItemsController;

        factory = new WimFactoryImpl();
        executor = new CommandExecutor();
        command = new ChangeStorySize(workItemsController);
        list = new ArrayList<>();
        panel = new JPanel();
        panel.setLayout(null);

        panel = new JPanel();
        panel.setLayout(null);

        frame = new JFrame(CHANGE_STORY_SIZE_WIM);
        frame.add(panel, BorderLayout.CENTER);
        frame.setLocation(200,200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        label1 = new JLabel(STORY_ID);
        label1.setBounds(10, 20, 110, 25);
        label1.setVerticalAlignment(SwingConstants.TOP);
        panel.add(label1);

        label2 = new JLabel(NEW_SIZE);
        label2.setBounds(10, 60, 110, 25);
        label2.setVerticalAlignment(SwingConstants.TOP);
        panel.add(label2);

        storyId = new JTextField();
        storyId.setBounds(150, 20, 200, 25);
        panel.add(storyId);

        comboBox1 = new JComboBox(strSize);
        comboBox1.setSelectedIndex(2);
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
        String choice = event.getActionCommand();
        switch (choice) {
            case CANCEL: {
                frame.setVisible(false);
            }
            break;
            case OK: {
                String str1 = storyId.getText();
                String str2 = comboBox1.getSelectedItem().toString();
                System.out.println(str1);
                System.out.println(str2);

                list.add(str1);
                list.add(str2);

                command = executor.changeStorySize(workItemsController);
                command.execute(list);
            }
            break;
        }
    }

}
