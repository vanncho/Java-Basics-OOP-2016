package pr06;

public class Number {
    private int number;
    private boolean prime;

    public Number(int number, boolean prime) {
        this.number = number;
        this.prime = prime;
    }

    boolean checkPrimeNumber(int number) {

        // Loop starts from 2
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    int nextPrimeNumber() {
        int n = this.number;

        while (true){
            n++;

            if (checkPrimeNumber(n)){
                return n;
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%d, %b", nextPrimeNumber(), checkPrimeNumber(this.number));
    }
}
