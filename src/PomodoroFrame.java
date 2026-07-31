import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.Timer;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Font;

public class PomodoroFrame extends javax.swing.JFrame {
    
    private JLabel timeLabel;
    private Timer timer;
    private int secondsLeft;
    private boolean isWorking;
    private final int workTime = 25 * 60; // 25 minutes
    private final int shortBreakTime = 5 * 60; // 5 minutes

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