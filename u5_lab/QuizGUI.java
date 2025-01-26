import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizGUI {
    private TFQuestion[] tfQuestions;
    private MCQuestion[] mcQuestions;
    private int currentTFIndex = 0;
    private int currentMCIndex = 0;
    private int score = 0;
    private boolean showingTF = true; // Start with TF questions

    private JFrame frame;
    private JLabel questionLabel;
    private JButton[] optionButtons;

    // Constructor
    public QuizGUI(Quiz quiz) {
        this.tfQuestions = quiz.getTFQuestions();
        this.mcQuestions = quiz.getMCQuestions();
        createGUI();
        displayQuestion();
    }

    // Set up the GUI
    private void createGUI() {
        frame = new JFrame("Trivia Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLayout(new BorderLayout());

        questionLabel = new JLabel("", SwingConstants.CENTER);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(questionLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 2));
        frame.add(buttonPanel, BorderLayout.CENTER);

        optionButtons = new JButton[4]; // Max of 4 buttons
        for (int i = 0; i < optionButtons.length; i++) {
            optionButtons[i] = new JButton();
            optionButtons[i].setFont(new Font("Arial", Font.PLAIN, 14));
            optionButtons[i].addActionListener(new AnswerButtonListener());
            buttonPanel.add(optionButtons[i]);
        }

        frame.setVisible(true);
    }

    // Display the current question
    private void displayQuestion() {
        if (showingTF && currentTFIndex < tfQuestions.length) {
            displayTFQuestion(tfQuestions[currentTFIndex]);
        } else if (!showingTF && currentMCIndex < mcQuestions.length) {
            displayMCQuestion(mcQuestions[currentMCIndex]);
        } else if (currentTFIndex >= tfQuestions.length && currentMCIndex >= mcQuestions.length) {
            showFinalScore();
        } else {
            showingTF = !showingTF; // Switch to the other type of question
            displayQuestion();
        }
    }

    // Display a true/false question
    private void displayTFQuestion(TFQuestion question) {
        questionLabel.setText(question.getQuestionText());
        String[] choices = {"True", "False"};

        for (int i = 0; i < optionButtons.length; i++) {
            if (i < 2) { // True/False only uses 2 buttons
                optionButtons[i].setText(choices[i]);
                optionButtons[i].setVisible(true);
            } else {
                optionButtons[i].setVisible(false);
            }
        }
    }

    // Display a multiple-choice question
    private void displayMCQuestion(MCQuestion question) {
        questionLabel.setText(question.getQuestionText());
        String[] choices = question.getAnswers();

        for (int i = 0; i < optionButtons.length; i++) {
            if (i < choices.length) {
                optionButtons[i].setText(choices[i]);
                optionButtons[i].setVisible(true);
            } else {
                optionButtons[i].setVisible(false);
            }
        }
    }

    // Show the final score
    private void showFinalScore() {
        JOptionPane.showMessageDialog(frame, "Quiz complete! You scored " + score + "/" + (tfQuestions.length + mcQuestions.length) + ".");
        frame.dispose();
    }

    // Listener for button clicks
    private class AnswerButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton clickedButton = (JButton) e.getSource();
            int selectedAnswer = -1;

            for (int i = 0; i < optionButtons.length; i++) {
                if (clickedButton == optionButtons[i]) {
                    selectedAnswer = i;
                    break;
                }
            }

            boolean isCorrect = false;
            if (showingTF && currentTFIndex < tfQuestions.length) {
                TFQuestion question = tfQuestions[currentTFIndex];
                isCorrect = (selectedAnswer == 0 && question.getAnswer()) || (selectedAnswer == 1 && !question.getAnswer());
                currentTFIndex++;
            } else if (!showingTF && currentMCIndex < mcQuestions.length) {
                MCQuestion question = mcQuestions[currentMCIndex];
                isCorrect = (selectedAnswer == question.getCorrectAnswer());
                currentMCIndex++;
            }

            if (isCorrect) {
                score++;
                JOptionPane.showMessageDialog(frame, "Correct!");
            } else {
                JOptionPane.showMessageDialog(frame, "Incorrect.");
            }

            showingTF = !showingTF; // Alternate between TF and MC questions
            displayQuestion();
        }
    }
}