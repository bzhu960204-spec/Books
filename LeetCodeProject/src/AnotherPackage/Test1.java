package AnotherPackage;

public class Test1 {
    int i;

    protected void yoo() {
        System.out.println("yooo");
    }

    public Test1(int i) {
        i = i;
        System.out.println("Test1 created");
    }

    public static void main(String[] args) {
//        System.out.println("a".hashCode());
//        String s = "ab";
//        System.out.println("ab".hashCode());
//        char[] chars = s.toCharArray();
//        int hashCode = 0;
//        for (int i = 0; i < chars.length; i++) {
//            hashCode += chars[i] * Math.pow(31, chars.length - 1 - i);
//        }
//        System.out.println(hashCode);
//        System.out.println(true & false);
        System.out.println(1&1);
        System.out.println(1&0);
        System.out.println(0&0);
    }
}
