package RandomTestCode;

import AnotherPackage.Test1;

import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Objects;

public class Test extends Test1 {
    private char a;

    private void method() {
        yoo();
    }

    public Test() {
        super(1);
        System.out.println("Test created");
    }

    public Test(char a) {
        super(1);
        a = a;
    }

    public static void main(String[] args) {
//        int[] a = new int[]{1, 2, 3};
//        int[] b = a;
//        a[0] = 2;
//        System.out.println(b[0]);
//
//        for (int i = 0; i < 10; i++) {
//
//            System.out.println(i);
//        }

//        A a = new B();
//        System.out.println(a.age);
//        a.hello();
//        String filePath = "D:\\Books\\计算机技术\\LeetCodeProject\\src\\LeetCode\\TopInterviewQuestions";
//        File file = new File(filePath);
//        System.out.println(file.listFiles().length);
//        DirectoryOutput.output(filePath);
//        Test test = new Test();
//        System.out.println(test.a);
//        short i = -1;
//        System.out.println(i >>> 10);
//        i >>>= 10;
//        System.out.println(i);
//        short a = -1;
//        a >>= 10;
//        System.out.println(a);
//        double a = 1.39e2;
//        System.out.println(a);
//        short a = Short.MAX_VALUE;
//        a += a;
//        System.out.println(a);
//        Test test = new Test();
//        test.yoo();

//        Test test = new Test('a');
        WeakReference<String> weakStringReference = new WeakReference<>("asdfasdf");

    }

}

class A {
    public int age = 10;

    public void hello() {
        System.out.println("A:" + this.age);
    }
}

class B extends A {
    public int age = 20;

    public void hello() {
        System.out.println("B:" + this.age);
    }
}

class DirectoryOutput {
    public static void output(String filePath) {
        File file = new File(filePath);
        if (file.listFiles() != null) {
            for (File file1 : Objects.requireNonNull(file.listFiles())) {
                String absoluteFilePath = file1.getAbsolutePath();
                System.out.println(absoluteFilePath);
                output(absoluteFilePath);
            }
        }
    }
}
