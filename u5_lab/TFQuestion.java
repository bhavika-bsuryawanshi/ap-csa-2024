public class TFQuestion {
   private String questionText;
   private boolean answer;
   private static int questionCount = 0;
   
   public TFQuestion(String s, boolean b)
   {
      questionText = s;
      answer = b;
   }
   
   public String getQuestionText()
   {
      return questionText;
   }

   public void setQuestionText(String s)
   {
      questionText = s;
   }

   public boolean getAnswer()
   {
      return answer;
   }

   public void setAnswer(boolean b)
   {
      answer = b;
   }

   public String toString()
   {
      return "The QUESTION is: " + questionText + " The ANSWER is : " + answer;
   }
   
   public boolean equals(TFQuestion other)
   {
      if (this.getQuestionText().equals(other.getQuestionText()) && this.getAnswer() == other.getAnswer())
      {
         return true;
      }
      else 
      {
         return false;
      }
   }
 }  