public class Main {
    /* 1. GCD:
    * Calculate the greatest common denominator of 2 given numbers
    * */
    public static int gcd(int a, int b) {
        if (a < b) return gcd(b, a);
        else if (a == b) return b;
        else if (b == 0) return a;
        return gcd(b, a%b);
    }

    /* 2. Cumulative Sum:
    * Sum numbers from a to b recursively
    * */
    public static int sumBetween(int a, int b) {
        if (a == b) {
            return b;
        }
        return a + sumBetween(a + 1, b);
    }

    /* 2.1.
    * Recursive function to sum numbers from 1 to x
    * */
    public static int sumTo(int x) {
        if (x == 0) {
            return 0;
        }
        return x + sumTo(x - 1);
    }

    /* 3. Find Second Largest:
    * recursively find the second-largest number in an array of integers
    * */
    public static int findSecondLargestHelper(int largest, int secondLargest, int index, int[] nums) {
        if (index == nums.length) {
            return secondLargest;
        }

        int element = nums[index];
        if (element > secondLargest) {
            if (element > largest) {
                return findSecondLargestHelper(element, largest, index + 1 ,nums);
            } else {
                return findSecondLargestHelper(largest, element, index + 1, nums);
            }
        }

        return findSecondLargestHelper(largest, secondLargest, index + 1, nums);
    }

    public static int findSecondLargest(int[] nums) {
        return findSecondLargestHelper(Integer.MIN_VALUE, Integer.MIN_VALUE, 0, nums);
    }

    /* 4. Sum of Digits:
    * Recursive function to calculate the digits in a number
    * */
    public static int sumOfDigits(int x) {
        if (x == 0) {
            return 0;
        }
        return x % 10 + sumOfDigits(x / 10);
    }

    /* 5. Ways to Climb Stairs
    * given an amount of stairs to climb, calculate the amount of ways to climb the stairs by taking either 1 or two steps at a time
    * */
    public static int countWaysToClimbHelper(int n) {
        if (n <= 1) {
            return n;
        }
        return countWaysToClimbHelper(n - 1) + countWaysToClimbHelper(n - 2);
    }
    public static int countWaysToClimb(int stairs) {
        return countWaysToClimbHelper(stairs + 1);
    }

    /* 6. Calculate log:
    * calculate the log of a given number in a certain base recursively
    * */
    public static int log(int base, int n) {
        if (n <= base) {
            return 1;
        } else {
            return 1 + log(base, n / base);
        }
    }

    /* 7. CountSubstrings
    * Find the amount of times a sequence appears in a particular word
    * */
    public static int countSubstrings(String sequence, String word) {
        int n1 = word.length();
        int n2 = sequence.length();

        if (n1 == 0 || n1 < n2) return 0;

        if (word.substring(0, n2).equals(sequence)) {
            return countSubstrings(sequence, word.substring(1)) + 1;
        }

        return countSubstrings(sequence, word.substring(1));
    }

    public static void main(String[] args) {
        System.out.println(sumOfDigits(12345));
    }
}