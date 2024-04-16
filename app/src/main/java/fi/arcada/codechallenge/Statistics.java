package fi.arcada.codechallenge;

public class Statistics {

    public static double calcMean(double[] values) {
        double sum = 0;
        for (int i = 0; i < values.length; i++) {
            sum += values[i];
        }

        return sum / values.length;
    }

    public static double[] sma3(double[] values) {
        double[] sma = new double[values.length];

        for (int i = 2; i < values.length; i++ ) {
            sma[i] = (values[i] + values[i-1] + values[i-2])/3;
        }
        return sma;
    }

    public static double[] sma(double[] values, int window) {
        double[] sma = new double[values.length];

        for (int i = window-1; i < values.length; i++ ) {
            double sum = 0;

            // Inre loop loopar igenom fönstret och adderar värdena
            for (int j = 0; j < window; j++) {
                sum += values[i-j]; // i-0, i-1, i-2 osv...
            }
            sma[i] = sum/window;
        }

        return sma;
    }
}
