package gui.commands;

import com.telerikacademy.wim.commands.contracts.Command;
import com.telerikacademy.wim.commands.creation.CreateMemberCommand;
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

public class CreateMemberGui extends JFrame implements ActionListener {

    private CommandExecutor executor;
    private WimFactory factory;
    private MembersController membersController;
    private Command command;
    private List<String> list;

    private static JPanel panel;
    private static JFrame frame;
    private static JLabel label;
    private JTextField createMember;
    private JButton btnOk;
    private JButton btnCancel;

    public CreateMemberGui(MembersController membersController) {
        this.membersController = membersController;

        executor = new CommandExecutor();
        factory = new WimFactoryImpl();
        command = new CreateMemberCommand(membersController, factory);
        list = new ArrayList<>();

        panel = new JPanel();
        panel.setLayout(null);

        frame = new JFrame(CREATE_MEMBER_WIM);
        frame.add(panel, BorderLayout.CENTER);
        frame.setLocation(200, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        label = new JLabel(MEMBER_NAME);
        label.setBounds(10, 20, 110, 25);
        label.setVerticalAlignment(SwingConstants.TOP);
        panel.add(label);

        createMember = new JTextField();
        createMember.setBounds(200, 20, 200, 25);
        panel.add(createMember);

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

        String choice = event.getActionCommand();
        switch (choice) {
            case CANCEL: {
                frame.setVisible(false);
            }
            break;
            case OK: {
                String name = createMember.getText();
                System.out.println(name);
                list.add(name);
                command = executor.createMember(membersController, factory);
                command.execute(list);
            }
            break;
        }
    }

}
