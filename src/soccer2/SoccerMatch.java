import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SoccerMatch extends JFrame {
    private int milanScore = 0;
    private int madridScore = 0;
    private JLabel resultLabel;
    private JLabel lastScorerLabel;
    private JLabel winnerLabel;

    public SoccerMatch() {
        setTitle("Soccer Match");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1));

        // Создание кнопок и меток
        JButton milanButton = new JButton("AC Milan");
        JButton madridButton = new JButton("Real Madrid");

        // Установка цвета фона и текста для кнопок
        milanButton.setBackground(Color.BLUE); // фон кнопки AC Milan
        milanButton.setForeground(Color.WHITE); // цвет текста на кнопке AC Milan
        madridButton.setBackground(Color.RED); // фон кнопки Real Madrid

        resultLabel = new JLabel("Result: 0 X 0", SwingConstants.CENTER);
        lastScorerLabel = new JLabel("Last Scorer: N/A", SwingConstants.CENTER);
        winnerLabel = new JLabel("Winner: DRAW", SwingConstants.CENTER);

        // Добавление обработчиков событий для кнопок
        milanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                milanScore++;
                updateGameStatus("AC Milan");
            }
        });

        madridButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                madridScore++;
                updateGameStatus("Real Madrid");
            }
        });

        // Добавление компонентов на фрейм
        add(resultLabel);
        add(lastScorerLabel);
        add(winnerLabel);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(milanButton);
        buttonPanel.add(madridButton);
        add(buttonPanel);

        setVisible(true);
    }

    private void updateGameStatus(String lastScorer) {
        resultLabel.setText("Result: " + milanScore + " X " + madridScore);
        lastScorerLabel.setText("Last Scorer: " + lastScorer);

        if (milanScore > madridScore) {
            winnerLabel.setText("Winner: AC Milan");
        } else if (madridScore > milanScore) {
            winnerLabel.setText("Winner: Real Madrid");
        } else {
            winnerLabel.setText("Winner: DRAW");
        }
    }

    public static void main(String[] args) {
        new SoccerMatch();
    }
}
