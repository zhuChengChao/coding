import java.util.Arrays;

public class Simple0066 {

    /* int 溢出问题
    public static int[] plusOne(int[] digits) {

        int num = 0;
        int len = digits.length;
        int lenNew = 1;
        int[] digitsNew;
        for (int i = 0; i < len; i++) {
            num += digits[i] * Math.pow(10, len-i-1);
        }

        num++;
        int temp = num;
        while ((temp = (temp / 10)) != 0){
            lenNew ++;
        }
        digitsNew = new int[lenNew];

        for (int i = 0; i < lenNew; i++) {
            digitsNew[lenNew-i-1] = num % 10;
            num = num/10;
        }

        return digitsNew;
    }*/

    public static int[] plusOne(int[] digits) {

        if (digits[digits.length-1] < 9){
            digits[digits.length-1] ++;
            return digits;

        }else {
            for (int i = digits.length-1; i >= 1; i--) {
                if (digits[i-1] != 9){
                    digits[i-1]++;
                    digits[i] = 0;
                    return digits;
                }else {
                    digits[i] = 0;
                }
            }

            int[] digitsNew = new int[digits.length+1];
            digitsNew[0] = 1;
            return digitsNew;
        }

        //
//        for (int i = digits.length - 1; i >= 0; i--) {
//            digits[i]++;
//            digits[i] = digits[i] % 10;
//            if (digits[i] != 0) return digits;
//        }
//        digits = new int[digits.length + 1];
//        digits[0] = 1;
//        return digits;
    }


    public static void main(String[] args) {

        int[] digits = new int[]{8, 9, 9, 9};
        int[] ints = plusOne(digits);
        System.out.println(Arrays.toString(ints));
    }
}
