import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;

public class getByName {
    private JPanel Mainview;
    private JLabel playerNameLabel;
    private JLabel nameLabel;
    private JTextField findPlayerTextfield;
    private JButton findPlayerButton;
    private JTextArea PlaterFoundTextArea;

    public getByName(){
        JFrame frame = new JFrame("Fantasy Football");
        frame.setContentPane(Mainview);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1300,400));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        findPlayerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {

                String name = findPlayerTextfield.getText();
                System.out.println(name);
                JavaCouchDB javaCouchDB = new JavaCouchDB();
                try {
                    String positionPlayers = javaCouchDB.getPlayer(name);
                    PlaterFoundTextArea.setText(null);
                    PlaterFoundTextArea.append(positionPlayers);

                } catch (MalformedURLException malformedURLException) {
                    malformedURLException.printStackTrace();
                }
            }
        });

    }
}
