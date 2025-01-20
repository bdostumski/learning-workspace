package gui.commands;

import com.telerikacademy.wim.commands.changes.AddCommentToWorkItem;
import com.telerikacademy.wim.commands.changes.CreateFeedbackInquiryInBoard;
import com.telerikacademy.wim.commands.contracts.Command;
import com.telerikacademy.wim.controllers.contracts.TeamsController;
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

public class AddCommentToWorkItemGui extends JFrame implements ActionListener {

    private CommandExecutor executor;
    private WimFactory factory;
    private WorkItemsController workItemsController;
    private Command command;
    private List<String> list;

    private static JPanel panel;

    private static JFrame frame;

    private static JLabel label1;
    private static JLabel label2;
    private static JLabel label3;

    JTextField itemId;
    JTextField message;
    JTextField author;

    JButton btnOk;
    JButton btnCancel;

    public AddCommentToWorkItemGui(WorkItemsController workItemsController)  {

        this.workItemsController = workItemsController;

        factory = new WimFactoryImpl();
        executor = new CommandExecutor();
        command = new AddCommentToWorkItem(workItemsController);
        list = new ArrayList<>();

        panel = new JPanel();
        panel.setLayout(null);

        frame = new JFrame(ADD_COMMENT_TO_ITEM_WIM);
        frame.add(panel, BorderLayout.CENTER);
        frame.setLocation(200,200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        label1 = new JLabel(ITEM_ID);
        label1.setBounds(10, 20, 110, 25);
        label1.setVerticalAlignment(SwingConstants.TOP);
        panel.add(label1);

        label2 = new JLabel(MESSAGE);
        label2.setBounds(10, 60, 110, 25);
        label2.setVerticalAlignment(SwingConstants.TOP);
        panel.add(label2);

        label3 = new JLabel(AUTHOR);
        label3.setBounds(10, 100, 110, 25);
        label3.setVerticalAlignment(SwingConstants.TOP);
        panel.add(label3);

        itemId = new JTextField();
        itemId.setBounds(110, 20, 200, 25);
        panel.add(itemId);

        message = new JTextField();
        message.setBounds(110, 60, 200, 25);
        panel.add(message);

        author = new JTextField();
        author.setBounds(110, 100, 200, 25);
        panel.add(author);

        btnOk = new JButton(OK);
        btnOk.setBounds(10, 160, 110, 25);
        panel.add(btnOk);

        btnCancel = new JButton(CANCEL);
        btnCancel.setBounds(200, 160, 110, 25);
        panel.add(btnCancel);

        frame.setSize(450, 250);

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
                String name1 = itemId.getText();
                String name2 = message.getText();
                String name3 = author.getText();
                System.out.println(name1);
                System.out.println(name2);
                System.out.println(name3);

                list.add(name1);
                list.add(name2);
                list.add(name3);

                command = executor.addCommentToWorkItem(workItemsController);
                command.execute(list);

            }
            break;
        }
    }


}
