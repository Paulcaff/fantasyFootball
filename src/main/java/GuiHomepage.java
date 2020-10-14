import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiHomepage {
    private JPanel Mainview;
    private JLabel HomeLabel;
    private JButton positionButton;
    private JButton squadSizeButton;
    private JButton playerButton;
    private JButton teamPlayersButton;
    private JButton DeletePlayerButton;
    private JButton AddPlayerButton;
    private JButton updateTeamButton;

    public GuiHomepage(){
        JFrame frame = new JFrame("Fantasy Football");
        frame.setContentPane(Mainview);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(600,400));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        positionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                getByPosition getByPosition =new getByPosition();
            }
        });

        squadSizeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                getSquadSize getSquadSize =new getSquadSize();
            }
        });

        playerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                getByName getByName =new getByName();
            }
        });

        teamPlayersButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                getByTeam getByTeam =new getByTeam();
            }
        });

        DeletePlayerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                deletePlayer deletePlayer = new deletePlayer();
            }
        });

        AddPlayerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                addTeamAndPlayer addTeamAndPlayer = new addTeamAndPlayer();
            }
        });

       updateTeamButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                updateTeamPlayers updateTeamPlayers = new updateTeamPlayers();
            }
        });
    }
}
