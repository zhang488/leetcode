package 数组;

public class Demo30位1的个数 {

    public static void main(String[] args) {
        Integer i = 11;
        System.out.println(Integer.toBinaryString(i));
    }

    public int hammingWeight(int n) {
        if(n <= 2) return 1;
        else{
            return hammingWeight(n/2) + n%2;
        }
    }
}
