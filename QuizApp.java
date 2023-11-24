
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizApp extends JFrame {
    private JTextField usernameField, seatNumberField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private int score;

    public QuizApp() {
        setTitle("Quiz Application");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(280, 190, 150, 25);
        add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(350, 190, 150, 25);
        add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(280, 240, 80, 25);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(350, 240, 150, 25);
        add(passwordField);

        JLabel seatNumberLabel = new JLabel("Seat Number:");
        seatNumberLabel.setBounds(260, 290, 100, 25);
        add(seatNumberLabel);

        seatNumberField = new JTextField();
        seatNumberField.setBounds(350, 290, 150, 25);
        add(seatNumberField);

        loginButton = new JButton("Login");
        loginButton.setBounds(260, 360, 100, 25);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });
        add(loginButton);

        setVisible(true);
    }

    private void login() {
        String username = usernameField.getText();
        char[] password = passwordField.getPassword();
        String seatNumber = seatNumberField.getText();

        if (username.equals("neha") && String.valueOf(password).equals("123") && seatNumber.equals("TE4118420")) {
            startQuiz();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid login credentials");
        }
    }

    private void startQuiz() {
        // Replace this with your actual quiz questions and scoring logic
        String[] questions = {"Question 1:What is the java developer name?", "Correct Syntax of 'Hello World' in java?", "Which method can be used to return a string in upper case letter?"};
        String[] answers = {"James Gosling", "System.out.println('Hello World');", "toUpperCase()"};

        for (int i = 0; i < questions.length; i++) {
            String response = JOptionPane.showInputDialog(this, questions[i]);
            if (response != null && response.equalsIgnoreCase(answers[i])) {
                score++;
            }
        }

        JOptionPane.showMessageDialog(this, "Quiz completed!\nYour score: " + score);
    }

    public static void main(String[] args) {
        new QuizApp();
    }
}