import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;

public class addPlayer {
    private JPanel Mainview;
    private JLabel topLabel;
    private JLabel teamLabel;
    private JLabel nameLabel;
    private JLabel positionLabel;
    private JLabel ageLabel;
    private JLabel priceLabel;
    private JLabel goalsLabel;
    private JLabel assistsLabel;
    private JLabel CleanSheetsLabel;
    private JTextField teamTextfield;
    private JTextField nametextfield;
    private JTextField positionTextfield;
    private JTextField ageTextfield;
    private JTextField priceTextfield;
    private JTextField goalsTextfield;
    private JTextField assistTextField;
    private JTextField cleansheetTextfield;
    private JButton AddButton;

    addPlayer(){
        JFrame frame = new JFrame("Fantasy Football");
        frame.setContentPane(Mainview);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1300,400));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        AddButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                String team = teamTextfield.getText();
                String name = nametextfield.getText();
                String position = positionTextfield.getText();
                int age = Integer.parseInt(ageTextfield.getText());
                float price = Float.parseFloat(priceTextfield.getText());
                int goals = Integer.parseInt(goalsTextfield.getText());
                int assists = Integer.parseInt(assistTextField.getText());
                int cleansheets = Integer.parseInt(cleansheetTextfield.getText());

                JavaCouchDB javaCouchDB = new JavaCouchDB();
                try {
                    javaCouchDB.createDocument(team,name,position,age,price,goals,assists,cleansheets);
                    JOptionPane.showMessageDialog(null,name+" added to CouchDB");

                } catch (MalformedURLException malformedURLException) {
                    malformedURLException.printStackTrace();
                }
            }
        });
    }
}
