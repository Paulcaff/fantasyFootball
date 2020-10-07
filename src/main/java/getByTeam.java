import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;

public class getByTeam {
    private JPanel Mainview;
    private JLabel welcomeLabel;
    private JLabel teamLabel;
    private JTextField teamTextfield;
    private JTextArea teamTextArea;
    private JButton submitButton;

    public getByTeam(){
        JFrame frame = new JFrame("Fantasy Football");
        frame.setContentPane(Mainview);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1300,400));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


        submitButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e)
        {

            String team = teamTextfield.getText();
            System.out.println(team);
            JavaCouchDB javaCouchDB = new JavaCouchDB();
            try {
                String teamPlayers = javaCouchDB.getPlayerByTeam(team);
                teamTextArea.setText(null);
                teamTextArea.append(teamPlayers);

            } catch (MalformedURLException malformedURLException) {
                malformedURLException.printStackTrace();
            }
        }
    });

    }
}
