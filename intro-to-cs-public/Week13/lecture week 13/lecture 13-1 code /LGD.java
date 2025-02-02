/** Linear Gradient Descent */
public class LGD{
   
   private static double a; // The computed coefficient (slope)

    /**
     * Trains the model, finds an estimate of the slope (computes a).  
     * @param x the dataset, each item contains one feature (a double)
     * @param y the target variable, which we would like to predict (a double)
     * @param T the number of iterations
     * @param learningRate used during training ("eta").
     */
    public static void train(double[] x, double[] y, int T, double learningRate) {
       a = Math.random();
       for (int t = 0; t < T; t++) {
          // Calculates the error
          double e = error(x, y);
          System.out.println("Error in iteration " + t + ": " + e);
       
          // Update rule
          a -= learningRate * derivativeAt(x, y);
       }
    }
    
    // Returns the error of the model for the given dataset
    private static double error(double[] x, double []y) {
        double e = 0;
        for (int i = 0; i < x.length; i++) {
           e += Math.pow(a * x[i] - y[i], 2);
        }
        return e;
     }
     
     // Returns the derivative value of the error
     private static double derivativeAt(double[] x, double []y) {
        double e = 0;
        for (int i = 0; i < x.length; i++) {
           e += 2 * (a * x[i] - y[i]) * x[i];
        }
        return e;
     }
     
    /**
     * Predicts the price of an unseen item.
     * @param x the item we would like to predict the target value for.
     * @return the target value.
     */
    public static double predict(double x) {	
       return a * x;
    }

    public static void main(String []args) {
        double[] x = {1, 1, 1, 1.5, 2, 2, 2, 2.5, 2.5, 3, 3, 4};
        double[] y = {1000000, 750000, 725000, 700000, 800000, 820000, 1050000, 1000000, 950000, 1200000, 1300000, 1250000};
        train(x, y, 10, 0.01);
        System.out.println(a);
        System.out.println("Price of a 2.5 room property:" + predict(2.5));
    }
 }