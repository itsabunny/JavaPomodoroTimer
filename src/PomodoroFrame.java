import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Font;

public class PomodoroFrame extends javax.swing.JFrame {
    
    private JLabel timeLabel;

    public PomodoroFrame() {
        setTitle("Pomodoro Timer");
        setSize(300, 200);
        setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setAlwaysOnTop(true);

        timeLabel = new JLabel("25:00", SwingConstants.CENTER);
        timeLabel.setFont(new Font("Arial", Font.BOLD, 42));

        JButton startButton = new JButton("Start");
        JButton pauseButton = new JButton("Pause");
        JButton resetButton = new JButton("Reset");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(startButton);
        buttonPanel.add(pauseButton);
        buttonPanel.add(resetButton);

        add(timeLabel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}