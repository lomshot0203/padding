package abstract_test;

public class TestMain {
    public static void main(String[] args) {
        AbstractVO vo1 = new Test1();
        AbstractVO vo2 = new Test2();

        testMethod(vo2);
    }

    public static void testMethod (AbstractVO param) {
        param.callVO();
    }
}
