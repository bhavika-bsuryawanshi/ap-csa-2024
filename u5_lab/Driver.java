public class Driver
{
   public static void main(String[] args)
   {
      // 5 true/false questions
      TFQuestion q1 = new TFQuestion("Are bananas actually berries?", true);
      TFQuestion q2 = new TFQuestion("Did caesar salads originate in Italy?", false);   
      TFQuestion q3 = new TFQuestion("Do peanuts belong to the nut family?", false); 
      TFQuestion q4 = new TFQuestion("Are avocados considered to be fruits?", true); 
      TFQuestion q5 = new TFQuestion("Lasagna actually originated in Greece, not Italy?", true);
      
      // tfQuestions array
      TFQuestion[] tfQuestions = { q1, q2, q3, q4, q5 };
      
      // 5 multiple choice questions
      MCQuestion q6 = new MCQuestion("Which fruit has its seeds on the outside?", new String[] { "Strawberry", "Apple", "Banana", "Orange" }, 0);
      MCQuestion q7 = new MCQuestion("What is the main ingredient in traditional guacamole?", new String[] { "Tomato", "Avocado", "Onion", "Garlic" }, 1);
      MCQuestion q8 = new MCQuestion("Which country is known for inventing sushi?", new String[] { "China", "Japan", "Korea", "Thailand" }, 1);
      MCQuestion q9 = new MCQuestion("What is the Italian dish made of layers of pasta, cheese, and meat?", new String[] { "Pizza", "Lasagna", "Risotto", "Spaghetti" }, 1);
      MCQuestion q10 = new MCQuestion("Which of the following is not a type of pasta?", new String[] { "Fusilli", "Tagliatelle", "Couscous", "Penne" }, 2);
      
      // mcQuestions array
      MCQuestion[] mcQuestions = { q6, q7, q8, q9, q10 };

      // initiating newQuiz object
      Quiz newQuiz = new Quiz(tfQuestions, mcQuestions);
      
      // print quiz overview
      System.out.println("Quiz Overview:");
      System.out.println(newQuiz.toString());

      // print isBalanced method 
      System.out.println("Is the quiz balanced? " + newQuiz.isBalanced());

      // duplicate quiz for equals method
      Quiz newQuizDup = new Quiz(tfQuestions, mcQuestions);
      System.out.println("\nAre the two quizzes equal? " + newQuiz.equals(newQuizDup)); 
      
      // quiz gui 
      QuizGUI newQuizGUI = new QuizGUI(newQuiz);
      
   }
}
