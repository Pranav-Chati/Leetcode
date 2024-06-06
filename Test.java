public class Test {

    /**
     * Given an array, find the average of all contiguous subarrays of size ‘K’ in
     * it.
     * 
     * Example:
     * [1, 4, 5, 6, -13, 4, 6], K=5
     */

    public static double kWindowAvg1(int[] array, int k) {
        double max_avg = 0.0;
        double avg;
        for (int i = 0; i <= array.length - k; i++) {
            avg = 0.0;
            for (int j = i; j <= (i + k - 1); j++) {
                avg += array[j];
            }
            avg /= k;
            if (max_avg < avg)
                max_avg = avg;
        }

        return max_avg;
    }

    public static double kWindowAvg2(int[] array, int k) {
        int windowStart = 0;
        int windowEnd = k - 1;

        int windowSum = 0;
        double windowAverage = 0.0;

        double maxAverage = 0.0;

        // calculate average for initial window
        for (int i = windowStart; i <= windowEnd; i++) {
            windowSum += array[i];
        }

        windowAverage = windowSum / (double) k;
        maxAverage = windowAverage;

        // calculate avg's for the rest of the windows and compare
        while (windowEnd < array.length - 1) {
            windowEnd++;
            windowSum += array[windowEnd];

            windowSum -= array[windowStart];
            windowStart++;

            windowAverage = windowSum / (double) k;
            if (maxAverage < windowAverage) {
                maxAverage = windowAverage;
            }
        }

        return maxAverage;
    }

    public static double kWindowAvg3(int[] array, int k) {
        int windowStart = 0;
        int windowEnd = 0;

        int windowSum = array[windowStart];
        double windowAverage = 0.0;
        double maxAverage = 0.0;

        while (windowEnd < array.length - 1) {
            windowEnd++;
            windowSum += array[windowEnd];

            if (windowEnd - windowStart >= k) {
                windowSum -= array[windowStart];
                windowStart++;

                windowAverage = windowSum / (double) k;
                if (maxAverage < windowAverage) {
                    maxAverage = windowAverage;
                }
            }
        }

        return maxAverage;

    }

    public static double[] kWindowAvgSoln(int[] arr, int k) {
        double[] result = new double[arr.length - k + 1];
        int windowSum = 0;
        int windowStart = 0;
        for (int windowEnd = windowStart; windowEnd < arr.length - 1; windowEnd++) {
            windowSum += arr[windowEnd];

            if (windowEnd >= k - 1) {
                // if (windowEnd - windowStart >= k) {
                result[windowStart] = windowSum / (double) k;
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }
        return result;

    }

    public static void main(String[] args) {
        int[] array = new int[] { 1, 3, 2, 6, -1, 4, 1, 8, 2 };
        int k = 5;

        // array = new int[] { 3, 6, 8, 10, -1 };
        // k = 2;

        System.out.println(kWindowAvg1(array, k));
        System.out.println(kWindowAvg2(array, k));
        System.out.println(kWindowAvg3(array, k));
        System.out.println(kWindowAvgSoln(array, k));

    }

}
