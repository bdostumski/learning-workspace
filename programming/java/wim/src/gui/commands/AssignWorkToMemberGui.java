package gui.commands;

import com.telerikacademy.wim.commands.changes.AssignWorkItemToMember;
import com.telerikacademy.wim.commands.contracts.Command;
import com.telerikacademy.wim.controllers.contracts.MembersController;
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

public class AssignWorkToMemberGui extends JFrame implements ActionListener {

    private CommandExecutor executor;
    private WimFactory factory;
    private MembersController membersController;
    private Command command;
    private List<String> list;

    private static JPanel panel;

    private static JFrame frame;

    private static JLabel label1;
    private static JLabel label2;

    JTextField memberName;
    JTextField ItemId;

    JButton btnOk;
    JButton btnCancel;

    public AssignWorkToMemberGui(MembersController membersController) {
        this.membersController = membersController;

        factory = new WimFactoryImpl();
        executor = new CommandExecutor();
        command = new AssignWorkItemToMember(membersController);
        list = new ArrayList<>();

        panel = new JPanel();
        panel.setLayout(null);

        frame = new JFrame(ASSIGN_ITEM_TO_MEMBER_WIM);
        frame.add(panel, BorderLayout.CENTER);
        frame.setLocation(200,200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        label1 = new JLabel(MEMBER_NAME);
        label1.setBounds(10, 20, 110, 25);
        label1.setVerticalAlignment(SwingConstants.TOP);
        panel.add(label1);

        label2 = new JLabel(ITEM_ID);
        label2.setBounds(10, 60, 110, 25);
        label2.setVerticalAlignment(SwingConstants.TOP);
        panel.add(label2);

        memberName = new JTextField();
        memberName.setBounds(150, 20, 200, 25);
        panel.add(memberName);

        ItemId = new JTextField();
        ItemId.setBounds(150, 60, 200, 25);
        panel.add(ItemId);

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
                String name1 = memberName.getText();
                String name2 = ItemId.getText();
                System.out.println(name1);
                System.out.println(name2);

                list.add(name1);
                list.add(name2);

                command = executor.assignWorkToMember(membersController);
                command.execute(list);

            }
            break;
        }
    }
}
