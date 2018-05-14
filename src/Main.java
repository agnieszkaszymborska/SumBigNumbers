public class Main {

    public static void main(String[] args) {
        BigNumberString first = new BigNumberString("1");
        BigNumberString second = new BigNumberString("99999999999999999999");
        System.out.println(first.add(second).toString());
    }
}
