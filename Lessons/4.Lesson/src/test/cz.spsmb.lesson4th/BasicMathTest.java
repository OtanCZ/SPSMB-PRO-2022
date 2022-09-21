package cz.spsmb.lesson4th;

import org.junit.jupiter.api.Test;


public class BasicMathTest {

    @Test
    public void factorialNumberLessThanZero() {
        long number = BasicMath.factorial(-26);
        assert number == 1;
    }

    @Test
    public void factorialNumberEqualToZero() {
        long number = BasicMath.factorial(0);
        assert number == 1;
    }

    @Test
    public void factorialNumberBiggerThanZero() {
        long number = BasicMath.factorial(5);
        assert number == 120;
    }

    @Test
    public void negativeNonPrimeNumber() {
        assert !BasicMath.isPrimeNumber(-88);
    }

    @Test
    public void negativePrimeNumber() {
        assert BasicMath.isPrimeNumber(-13);
    }

    @Test
    public void zeroPrimeNumber() {
        assert !BasicMath.isPrimeNumber(0);
    }

    @Test
    public void primeNumber() {
        assert BasicMath.isPrimeNumber(11);
    }

    @Test
    public void noGcd() {
        assert BasicMath.gcd(234234, 43234523) == 1;
    }

    @Test
    public void testGcd() {
        assert BasicMath.gcd(522236, 4266691) == 143;
    }

    @Test
    public void testSwitchedGcd() {
        assert BasicMath.gcd(4266691, 522236) == 143;
    }

    @Test
    public void testNegativeGcd() {
        assert BasicMath.gcd(-4266691, 522236) == -1;
    }

    @Test
    public void testNegativeGcdTwo() {
        assert BasicMath.gcd(4266691, -522236) == -1;
    }

}
