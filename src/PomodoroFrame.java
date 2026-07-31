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

        secondsLeft = workTime;
        isWorking = true;

        timeLabel = new JLabel("25:00", SwingConstants.CENTER);
        timeLabel.setFont(new Font("Arial", Font.BOLD, 42));

        JButton startButton = new JButton("Start");
        JButton pauseButton = new JButton("Pause");
        JButton resetButton = new JButton("Reset");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(startButton);
        buttonPanel.add(pauseButton);
        buttonPanel.add(resetButton);

        startButton.addActionListener(e -> timer.start());
        pauseButton.addActionListener(e -> timer.stop());
        resetButton.addActionListener(e -> {
            timer.stop();
            secondsLeft = workTime;
            isWorking = true;
            updateLabel();
        });

        add(timeLabel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

                timer = new Timer (1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (secondsLeft > 0) {
                    secondsLeft--;
                    updateLabel();
                } else {
                    timer.stop();
                    if (isWorking) {
                        System.out.println("Work session completed! Time for a short break.");
                    } else {    
                        System.out.println("Break session completed! Time to get back to work.");
                    }
                }
            }
        });

    }

    private void updateLabel() {
        int minutes = secondsLeft / 60;
        int seconds = secondsLeft % 60;
        timeLabel.setText(String.format("%02d:%02d", minutes, seconds));
    }
}