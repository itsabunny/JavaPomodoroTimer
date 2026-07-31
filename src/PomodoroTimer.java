import javax.swing.SwingUtilities;

public class PomodoroTimer {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PomodoroFrame frame = new PomodoroFrame();
            frame.setVisible(true);
        });
    }
}