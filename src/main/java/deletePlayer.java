import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;

public class deletePlayer {
    private JPanel Mainview;
    private JLabel topLabel;
    private JLabel deletePlayerLabel;
    private JTextField deletePlayerTextfield;
    private JButton submitButton;

    public deletePlayer() {
        JFrame frame = new JFrame("Fantasy Football");
        frame.setContentPane(Mainview);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(600, 400));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String playerTobeDeleted = deletePlayerTextfield.getText();
                System.out.println(playerTobeDeleted);
                JavaCouchDB javaCouchDB = new JavaCouchDB();
                try {
                    javaCouchDB.deleteDocument(playerTobeDeleted);
                    JOptionPane.showMessageDialog(null,playerTobeDeleted + " has been deleted");

                } catch (MalformedURLException malformedURLException) {
                    malformedURLException.printStackTrace();
                }
            }
        });
    }
}
