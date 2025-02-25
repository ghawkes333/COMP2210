/**
 * HandoutExamples.java
 * Generates examples from the assignment handout.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2018-04-17
 *
 */
public class HandoutExamples {

    /** Drives execution. */
    public static void main(String[] args) {
        String sourceText = "agggcagcgggcg";
        int k = 2;
        MarkovModel model = new MarkovModel(k, sourceText);
        System.out.println("k = " + k + ", source text: " + sourceText);
        System.out.println("The first kgram: " + model.getFirstKgram());
        System.out.println("A random kgram: " + model.getRandomKgram());
        System.out.println("All kgrams: " + model.getAllKgrams());
        System.out.println("The Markov model: ");
        System.out.println(model);
        
        MarkovModel m2 = new MarkovModel(1, "xyZa");
        System.out.println("Test: " + m2.getNextChar("a"));
        
        int c = 0;
        for (int i = 0; i < 1000; i++){
         int r = randInt(1, 10);
         if (r == 1) c++;
         }
         System.out.println(c);
    }
    
      private static int randInt (int low, int high){
      int rand = (int) (low + ((Math.random() * ((high + 1) - low))));
      return rand; 
   }
}


/*

RUNTIME OUTPUT:

k = 2, source text: agggcagcgggcg
The first kgram: ag
A random kgram: cg
All kgrams: [gg, cg, ag, gc, ca]
The Markov model:
{gg=gcgc, cg=g, ag=gc, gc=agg, ca=g}

 */

