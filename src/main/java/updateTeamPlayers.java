import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;

public class updateTeamPlayers {
    private JPanel Mainview;
    private JLabel TopLabel;
    private JLabel nameLabel;
    private JLabel positionLabel;
    private JLabel ageLabel;
    private JLabel priceLabel;
    private JLabel goalsLabel;
    private JLabel assistsLabel;
    private JLabel cleansheetLabel;
    private JTextField nametextField;
    private JTextField positionTextfield;
    private JTextField ageTextfield;
    private JTextField priceTextfield;
    private JTextField goalsTextfield;
    private JTextField assistsTextfield;
    private JTextField cleansheetsTextfield;
    private JLabel idLabel;
    private JTextField idTextfield;
    private JButton submitButton;

    updateTeamPlayers(){
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
                String id = idTextfield.getText();
                String name = nametextField.getText();
                String position = positionTextfield.getText();
                int age = Integer.parseInt(ageTextfield.getText());
                float price = Float.parseFloat(priceTextfield.getText());
                int goals = Integer.parseInt(goalsTextfield.getText());
                int assists = Integer.parseInt(assistsTextfield.getText());
                int cleansheets = Integer.parseInt(cleansheetsTextfield.getText());

                JavaCouchDB javaCouchDB = new JavaCouchDB();
                try {
                    javaCouchDB.updateDocument(id,name,position,age,price,goals,assists,cleansheets);
                    JOptionPane.showMessageDialog(null,name+" added to CouchDB");

                } catch (MalformedURLException malformedURLException) {
                    malformedURLException.printStackTrace();
                }
            }
        });
    }
}
