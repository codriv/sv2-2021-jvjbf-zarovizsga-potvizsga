package numbers;

public class ArmstrongNumbers {

    public boolean isArmstrongNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Number can't be negative: " + number);
        }
        int sum = getSum(number);
        return number == sum;
    }

    private int getSum(int number) {
        int n = String.valueOf(number).length();
        String[] nubers = String.valueOf(number).split("");
        int sum = 0;
        for (String num: nubers) {
            sum += Math.pow(Integer.parseInt(num), n);
        }
        return sum;
    }
}
