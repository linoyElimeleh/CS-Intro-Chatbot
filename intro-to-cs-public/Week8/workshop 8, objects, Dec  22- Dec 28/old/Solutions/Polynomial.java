public class Polynomial {
    private final double[] coefficients;
    public Polynomial(double[] coefficients) {
        int degree = coefficients.length-1;
        while(degree >= 0 && coefficients[degree] == 0){
            degree--;
        }
        this.coefficients = new double[degree+1];
        for(int i=0; i<=degree; i++) {
            this.coefficients[i] = coefficients[i];
        }
    }

    public double evaluate(double x) {
        double result = 0;
        for (int i = 0; i < this.coefficients.length; i++) {
            result += this.coefficients[i]*Math.pow(x,i);
        }
        return result;
    }

    public Polynomial derivative() {
        double[] newMultipliers = new double[this.coefficients.length-1];
        for (int i = 1; i < this.coefficients.length; i++) {
            newMultipliers[i-1] = this.coefficients[i]*i;
        }

        return new Polynomial(newMultipliers);
    }

    public Polynomial integral() {
        double[] newMultipliers = new double[this.coefficients.length+1];
        for (int i = 1; i <= this.coefficients.length; i++) {
            newMultipliers[i] = this.coefficients[i-1]/i;
        }

        return new Polynomial(newMultipliers);
    }

    private double[] findZeroPoints(int minX, int maxX) {
        int lastCritical = 0;
        double[] criticalPoints = new double[this.coefficients.length];

        double lastEvaluated = this.evaluate(minX);

        for (double x = minX+1; x <= maxX; x += 1) {
            double eval = this.evaluate(x);
            if (lastEvaluated * eval <= 0) {
                criticalPoints[lastCritical] = x;
                lastCritical++;
                if (eval == 0) {
                    eval = -lastEvaluated;
                }
            }
            lastEvaluated = eval;
        }

        double[] minifiedCriticalPointsArray = new double[lastCritical];
        for (int i=0; i<lastCritical; i++) {
            minifiedCriticalPointsArray[i] = criticalPoints[i];
        }

        return minifiedCriticalPointsArray;
    }

    public double[] findCriticalPoints(int minX, int maxX) {
        Polynomial derivative = this.derivative();
        return derivative.findZeroPoints(minX, maxX);
    }

    private double calcDifferenceInEvaluations(double x1, double x2) {
        return this.evaluate(x2) - this.evaluate(x1);
    }
    public double calculateArea(int minX, int maxX) {
        double[] zeroPoints = this.findZeroPoints(minX, maxX);
        Polynomial integeral = this.integral();
        if (zeroPoints.length == 0) {
            return Math.abs(integeral.calcDifferenceInEvaluations(minX,maxX));
        }
        double sum = Math.abs(integeral.calcDifferenceInEvaluations(minX,zeroPoints[0]));
        sum += Math.abs(integeral.calcDifferenceInEvaluations(zeroPoints[zeroPoints.length-1],maxX));
        for (int i=0; i<zeroPoints.length-1; i++) {
            sum += Math.abs(integeral.calcDifferenceInEvaluations(zeroPoints[i],zeroPoints[i+1]));
        }

        return sum;
    }

    public String toString() {
        String result = "";
        if (this.coefficients[0] != 0) {
            result += this.coefficients[0];
            if (this.coefficients[0] > 0) {
                result = "+"+result;
            }
        }
        for (int i = 1; i < this.coefficients.length; i++) {
            double coefficient = coefficients[i];
            String xPow = "X";
            if (i>1){
                xPow += "^"+i;
            }
            if (coefficient == 0) {
                continue;
            }
            result = coefficient+xPow+result;
            if (coefficient > 0) {
                result = "+"+result;
            }
        }

        if (result == "") {
            return "0";
        }
        if (result.charAt(0) == '+'){
            result = result.substring(1);
        }
        return result;
    }

    private static double getValueOrZeroIfOutBoundaries(double[] array, int index) {
        if (index >= array.length) {
            return 0;
        }

        return array[index];
    }

    public static double[] getIntersections (Polynomial p1, Polynomial p2, int minX, int maxX) {
        double[] coefficients = new double[Math.max(p1.coefficients.length, p2.coefficients.length)];
        for (int index=0; index<coefficients.length; index++) {
            double p1_coefficient = getValueOrZeroIfOutBoundaries(p1.coefficients, index);
            double p2_coefficient = getValueOrZeroIfOutBoundaries(p2.coefficients, index);
            coefficients[index] = p1_coefficient - p2_coefficient;
        }

        Polynomial subPolynomials = new Polynomial(coefficients);
        return subPolynomials.findZeroPoints(minX, maxX);
    }
}
