import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;

public class getByPosition{

    public JPanel Mainview;
    private JTextField positionTextfield;
    private JButton positionSubmitBtn;
    private JTextArea PositionPlayersTextArea;
    private JLabel GetPositionLabel;
    private JLabel positionLabel;


    public getByPosition(){
        JFrame frame = new JFrame("Fantasy Football");
        frame.setContentPane(Mainview);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(800,400));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);



        positionSubmitBtn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                // display/center the jdialog when the button is pressed
                String position = positionTextfield.getText();
                System.out.println(position);
                JavaCouchDB javaCouchDB = new JavaCouchDB();
                try {
                    String positionPlayers = javaCouchDB.getPlayerByPosition(position);
                    PositionPlayersTextArea.setText(null);
                    PositionPlayersTextArea.append(positionPlayers);

                } catch (MalformedURLException malformedURLException) {
                    malformedURLException.printStackTrace();
                }
            }
        });

    }

}

