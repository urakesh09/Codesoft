import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizApp extends JFrame implements ActionListener {
    private String[][] questions = {
        {"What is the capital of France?", "Paris", "London", "Berlin", "Madrid", "Paris"},
        {"Which is the largest planet?", "Earth", "Mars", "Jupiter", "Venus", "Jupiter"},
        {"Who developed Java?", "Microsoft", "Apple", "Sun Microsystems", "Google", "Sun Microsystems"}
    };

    private int questionIndex = 0, score = 0, timeLeft = 10;
    private JLabel questionLabel, timerLabel, scoreLabel;
    private JRadioButton[] options;
    private JButton submitButton;
    private ButtonGroup group;
    private Timer timer;

    public QuizApp() {
        setTitle("Quiz Application");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        questionLabel = new JLabel("", JLabel.CENTER);
        timerLabel = new JLabel("Time Left: 10", JLabel.RIGHT);
        scoreLabel = new JLabel("Score: 0", JLabel.LEFT);

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(scoreLabel, BorderLayout.WEST);
        topPanel.add(timerLabel, BorderLayout.EAST);

        JPanel questionPanel = new JPanel(new GridLayout(5, 1));
        questionPanel.add(questionLabel);

        options = new JRadioButton[4];
        group = new ButtonGroup();
        for (int i = 0; i < 4; i++) {
            options[i] = new JRadioButton();
            group.add(options[i]);
            questionPanel.add(options[i]);
        }

        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(submitButton);

        add(topPanel, BorderLayout.NORTH);
        add(questionPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        loadQuestion();

        timer = new Timer(1000, e -> updateTimer());
        timer.start();
    }

    private void loadQuestion() {
        if (questionIndex >= questions.length) {
            showResult();
            return;
        }
        questionLabel.setText(questions[questionIndex][0]);
        for (int i = 0; i < 4; i++) {
            options[i].setText(questions[questionIndex][i + 1]);
        }
        group.clearSelection();
        timeLeft = 10;
        timerLabel.setText("Time Left: " + timeLeft);
    }

    private void updateTimer() {
        timeLeft--;
        timerLabel.setText("Time Left: " + timeLeft);
        if (timeLeft == 0) {
            nextQuestion();
        }
    }

    private void nextQuestion() {
        timer.stop();
        String correctAnswer = questions[questionIndex][5];
        for (JRadioButton option : options) {
            if (option.isSelected() && option.getText().equals(correctAnswer)) {
                score++;
                scoreLabel.setText("Score: " + score);
            }
        }
        questionIndex++;
        loadQuestion();
        timer.restart();
    }

    private void showResult() {
        JOptionPane.showMessageDialog(this, "Quiz Over! Your Score: " + score + "/" + questions.length);
        System.exit(0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        nextQuestion();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new QuizApp().setVisible(true));
    }
}
