package org.example.practice;


public class BitManipulation {

    public static int testBitManipulationXor(int a) {
        return a << 1;
    }

    public static int testBitManipulation(int a) {
        return a >> 1;
    }

    public static String evenOddNumber(int a) {
        if ((a & 1) == 1) return "Odd";    // when last bit is one then odd .
        if ((a & 1) == 0) return "Even";   // when last bit is zero then even.
        return null;
    }

    public static void multiplyBy2(int a) {
        System.out.println((a << 1) + " = " + a + " * 2");
        System.out.println(Integer.toBinaryString(a << 3));
    }

    // 5=0101
    // for 1 =10  5*2^1 =5*2  =1010   right shift one bit
    // for 2 =20  5*2^2 =5*4  =10100
    // for 3 =40  5*2^3 =5*8  =101000


    public static void divideBy2(int a) {
        System.out.println((a >> 1) + " = " + a + " / 2");
    }
    //for 1 = 2(output)  4/2^1 =  4/2
    //for 2 = 1   4/2^2  = 4/4

    public static void SetIthBitTo1(int n, int bitNumber) {
        System.out.println((n | (1 << bitNumber)) + " after bit change.");
        //0001  it has set the 1st bit to one like 0011
    }

    public static void clearIthBit(int n, int bitNumber) {
        System.out.println((n & ~(1 << bitNumber)) + " after bit change.");
        //0101 it has cleared the 0001  5 change to 1
    }

    public static void toggleTheIthBit(int n, int bitNumber) {
        System.out.println((n ^ (1 << bitNumber)) + " after bit change.");
        //0101 it has cleared the 0001  5 change to 1
    }

    public static void countTheSetBits(int n) {
        int count = 0;
        while (n > 0) {
            n = n & (n - 1);   // this is because it removes the last active bits.
            count++;            // we need to only count the active set bits.
        }
        System.out.println(count);
    }

    public static boolean isPowerOf2(int n) {
        return (n > 0) && ((n & (n - 1)) == 0);
    }

    public static int nonRepeatingNumberInArray(int[] a) {
        int result = 0;
        for (int num : a)
            result ^= num;    /// this xor will can cle out element if form same a ^a = 0
        return result;    // this logic work if array elemnt are same excet one unique elemtn.
    }

    public static boolean checkIfIthBitIs1(int n, int i) {
        return ((n & (1 << i)) != 0);
    }

    public static void checkIfNumberIsPowerOfTwo(int n) {
        // only one active bit should be present then it is the power of two.

        if (n > 0 && ((n & (n - 1)) == 0)) {
            System.out.println("This number is power of two.");
        } else {
            System.out.println("This number is not the power of two. ");
        }
    }

    public static void swapTwoNumbers(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a + " = a" + b + " = b");
    }

    //* important
    public static void performDivision(int dividend, int divisor) {

        boolean negativeBit = (dividend > 0) ^ (divisor > 0);

        int dvd = Math.abs(dividend);
        int dvs = Math.abs(divisor);

        int result = 0;
        for (int i = 31; i >= 0; i--) {
            if ((dvd >>> i) >= dvs) {
                result += (1 << i);
                dvd -= (dvs << i);
            }
        }
        System.out.println(negativeBit ? -result : result);
    }

    //* important
    public static void findOutNonRepeatingtwoNumbers(int[] a) {
        int xor = 0;
        for (int number : a) {
            xor = xor ^ number;  //here all number exor will happens.
        }
        // now we got the xor we have to find out the right most set bit so we do n &(-n)
        int rightMostOne = xor & (-xor);
        // now we will devide the array in two parts and take the xor to cancel the duplicates elements.
        int number1 = 0;
        int number2 = 0;
        for (int number : a) {
            if ((number & rightMostOne) == 0) {       // this is important point  where right most  bit is used to difference the two group
                number1 ^= number;
            } else {
                number2 ^= number;
            }
        }
        System.out.println("The first number is n1 =" + number1 + " and  second number is n2 = " + number2);
    }

    public static void addTwoNumberS(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;   /// carry taken out
            a = a ^ b;  ///sum without carry;
            b = carry;
        }
        System.out.println(a + " = sum of a+b with carry.");
    }

//            a & b   → tells where the carry is
//            a ^ b   → gives sum (ignoring carry)
//            (a & b) << 1 → tells where to apply that carry in next step

    public static void addOneToTheNumber(int a){
        int carry =1;
        while((a & carry)!=0){
            a=  a ^ carry ;   // sum happening hear.
            carry = carry<< 1;   // right shift for carry
        }
        a=a ^ carry;  /// last carry if occurred.
        System.out.println(a + " add 1 two number without +.");
    }
}
