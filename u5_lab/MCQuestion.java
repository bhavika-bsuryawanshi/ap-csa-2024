public class MCQuestion 
{
   private String questionText;
   private int correctAnswer;
   private String[] answers;
   public static int questionCount = 0;
   
   // constructors
   public MCQuestion(String s, String[] a, int c)
   {
      questionText = s;
      answers = a;
      correctAnswer = c;
   }
   
   public MCQuestion(String s, int c)
   {
      questionText = s;
      answers = new String[4];
      correctAnswer = c;
   }
   
   // get/set question text
   public String getQuestionText()
   {
      return questionText;
   } 
   
   public void setQuestionText(String s)
   {
      questionText = s;  
   }
   
   // get/set answers
   public String[] getAnswers() 
   {
      return answers;
   }
   
   public void setAnswers(String s, int i)
   {
      answers[i] = s;
   }
   
   // get/set correct answer
   public int getCorrectAnswer()
   {
      return correctAnswer;
   }
   
   // get/set correctAnswer
   public void setCorrectAnswer(int c) 
   {
      correctAnswer = c;
   }
   
   public String getCorrectAnswerText() 
   {
      return answers[correctAnswer];
   }
   
   // setAnswer method 
   public void setAnswer(String s, int i)
   {
      correctAnswer = i;
      answers[i] = s;
   }
   
   public String toString()
   {
      return getQuestionText() + ", Answer Choices: A:" + answers[0] + ", B: " + answers[1] + ", C: " + answers[2] + ", D: " + answers[3] + ". Correct Answer: " + getCorrectAnswerText();
   }
   
   public static boolean equalArrays(String[] a1, String[] a2)
   {
      boolean EA = false;
      if (a1.length == 4 && a2.length == 4)
      {
         for (int i = 0; i < a1.length; i++) {
             if (a1[i] == a2[i])
             { EA = true; }
             else 
             { EA = false; break; }
         }
      }
      return EA;
   }
   
      
   public boolean equals(MCQuestion a)
   {
      boolean e1 = equalArrays(this.answers, a.answers);
      boolean e2 = this.correctAnswer == a.correctAnswer;
      boolean e3 = this.getQuestionText().equals(a.getQuestionText());
      return e1 && e2 && e3;
   }
   
   
   
}