import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;

public class getSquadSize {
    private JPanel MainView;
    private JTextField teamTextfield;
    private JLabel TeamLabel;
    private JLabel SelectTeamLabel;
    private JLabel resultLabel;
    private JButton submitButton;
    private JLabel squadSizeLabel;

    public getSquadSize(){
        JFrame frame = new JFrame("Fantasy Football");
        frame.setContentPane(MainView);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(600,400));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {

                String name = teamTextfield.getText();
                System.out.println(name);
                JavaCouchDB javaCouchDB = new JavaCouchDB();
                try {

                    String teamSize = "";
                    int team =  javaCouchDB.getSquadSize(name);
                    String result = Integer.toString(team);

                    resultLabel.setText(result);

                } catch (MalformedURLException malformedURLException) {
                    malformedURLException.printStackTrace();
                }
            }
        });

    }
}
