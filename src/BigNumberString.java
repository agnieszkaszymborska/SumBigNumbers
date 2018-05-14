
public class BigNumberString {
    private int[] digits;

    public BigNumberString(String number) {
        digits = new int[number.length()];
        for(int i = 0; i < number.length(); i++) {
            digits[i] = number.charAt(i) - '0';
        }
    }

    public BigNumberString add(BigNumberString second) {
        int firstNumberLength = this.digits.length - 1;
        int secondNumberLength = second.digits.length - 1;
        int digit = 0;
        int carry = 0;
        int sum = 0;

        StringBuilder stringBuilder = new StringBuilder();

        while(firstNumberLength >= 0 && secondNumberLength >= 0) {
            sum = this.digits[firstNumberLength] + second.digits[secondNumberLength] + carry;
            digit = sum % 10;
            carry = sum / 10;
            stringBuilder.append((char) (digit + '0'));
            firstNumberLength--;
            secondNumberLength--;
        }

        while (firstNumberLength >= 0) {
            sum = this.digits[firstNumberLength] + carry;
            digit = sum % 10;
            carry = sum / 10;
            stringBuilder.append((char) (digit + '0'));
            firstNumberLength--;
        }

        while (secondNumberLength >= 0) {
            sum = second.digits[secondNumberLength] + carry;
            digit = sum % 10;
            carry = sum / 10;
            stringBuilder.append((char) (digit + '0'));
            secondNumberLength--;
        }

        if(carry > 0) {
            stringBuilder.append((char) (carry + '0'));
        }

        return new BigNumberString(stringBuilder.reverse().toString());
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < this.digits.length; i++) {
            stringBuilder.append((char) (this.digits[i] + '0'));
        }
        return stringBuilder.toString();
    }

}
