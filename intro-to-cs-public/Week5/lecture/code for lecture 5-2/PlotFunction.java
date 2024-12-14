/** Plots functions. */
public class PlotFunction {
	
	  // Demonstrates plotting three functions.
	  // De-comment the function that you want to plot.
	  // Oher functions can be defined, as needed.

    // f(x) = x * x
    public static double f(double x) {
   	    return x * x;
    }
    
    /*
    // f(x) = sin(x)
    public static double f(double x) {
   	    return Math.sin(x);
    }
    */
    
    /*
    // f(x) = sin(4 * x) + sin(20 * x)
    public static double f(double x) {
   	    return Math.sin(4 * x) + Math.sin(20 * x);
    }
    */

    /*
    // f(x) = -5 * x * x * x + 10 * x + 2
    public static double f(double x) {
   	    return -5 * (x * x * x) + 10 * x + 2;
    }
    */
	
    public static void main(String[] args) {
        double xMin = Double.parseDouble(args[0]);
        double xMax = Double.parseDouble(args[1]);
        int N = Integer.parseInt(args[2]);
      
        // Creates arrays for the x values and y values
        double x[] = xArr(xMin, xMax, N);   
        double y[] = f(x);
     
        // Scales the canvas
        StdDraw.setXscale(xMin, xMax); 
        StdDraw.setYscale(min(y), max(y));  
 
        // Connects the (x,y) points
        for (int i = 0; i < N; i++) {
            StdDraw.line(x[i], y[i], x[i + 1], y[i + 1]);
        }
    }
   
    // Returns an array that represents N equally-spaced
    // points between a and b
    public static double[] xArr(double a, double b, int N) {
    	double[] x = new double[N + 1];
    	double interval = (b - a) / N;
        for (int i = 0; i <= N; i++) {
            x[i] = a + (i * interval);
        }
        return x;
    }
    
    // Returns the array f(x[])
    public static double[] f(double x[]) {
    	int N = x.length;
        double[] y = new double[N];
        for (int i = 0; i < N; i++) {
            y[i] = f(x[i]);  // computes y=f(x)
        }
        return y;
    }
        
    // Returns the minimum value in the given array
    public static double min(double arr[]) {
       double min = arr[0];
       for (int i = 0; i < arr.length; i++) {
          if (arr[i] < min) {
             min = arr[i];
          }
       }
       return min;
    }

     // Returns the maximum value in the given array
     public static double max(double arr[]) {
        double max = arr[0];
        for (int i = 0; i < arr.length; i++) {
           if (arr[i] > max) {
              max = arr[i];
           }
         }
         return max;
      }
  }