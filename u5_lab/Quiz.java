public class Quiz
{
   TFQuestion[] tfquestions = new TFQuestion[10];
   MCQuestion[] mcquestions = new MCQuestion[10];
   
   // constructor 
   public Quiz(TFQuestion[] tf, MCQuestion[] mc)
   {
      tfquestions = tf;
      mcquestions = mc;
   }
   
   // get/set tfquestions
   public TFQuestion[] getTFQuestions()
   {
      return tfquestions;
   }
   
   public void setTFQuestions(TFQuestion[] tf)
   {
      tfquestions = tf;
   }
   
   // get/set mcquestion
   public MCQuestion[] getMCQuestions()
   {
      return mcquestions;
   }
   
   public void setMCQuestions(MCQuestion[] mc)
   {
      mcquestions = mc;
   }
   
   // isBalanced method
   public boolean isBalanced()
   {
      return tfquestions.length == mcquestions.length;
   }
   
   public String toString()
   {
        String result = "";
        for (int i = 0; i < tfquestions.length; i++) 
        {
            result += tfquestions[i].toString() + "\n";
        }

        for (int i = 0; i < mcquestions.length; i++) 
        {
            result += mcquestions[i].toString() + "\n";
        }
        return result;
   }
   
   public boolean equals(Quiz q)
   {
      if (!this.isBalanced() || !q.isBalanced()) 
      {
        return false; 
      }
      
      for (int i = 0; i < this.tfquestions.length; i++) 
      {
        if (!this.tfquestions[i].equals(q.tfquestions[i])) 
        {
            return false;
        }
      }
    
      for (int i = 0; i < this.mcquestions.length; i++) 
      {
        if (!this.mcquestions[i].equals(q.mcquestions[i])) 
        {
            return false;
        }
      }

    return true;
    
   }
   
   
}