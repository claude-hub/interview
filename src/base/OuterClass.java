package base;

/**
 * 内部类
 *
 * @author Cloudy
 */
public class OuterClass {
    private static String name = "chenssy";

    /**
     * 静态内部类
     */
    private static class InnerClass1 {
        /**
         * 在静态内部类中可以存在静态成员
         */
        private static String name1 = "chenssy_static";

        private void display() {
            // 静态内部类只能访问外围类的静态成员变量和方法
            // 不能访问外围类的非静态成员变量和方法
            System.out.println("OutClass name :" + name);
        }
    }

    /**
     * 非静态内部类
     */
    private class InnerClass2 {
        /**
         * 非静态内部类中不能存在静态成员
         */
        private String name2 = "chenssy_inner";

        /**
         * 非静态内部类中可以调用外围类的任何成员,不管是静态的还是非静态的
         */
        private void display() {
            System.out.println("OuterClass name：" + name);
        }
    }

    /**
     * 外围类方法
     */
    private void display() {
        // 外围类访问静态内部类：内部类
        System.out.println(InnerClass1.name1);
        // 静态内部类 可以直接创建实例不需要依赖于外围类
        new InnerClass1().display();

        // 非静态内部的创建需要依赖于外围类
        OuterClass.InnerClass2 inner2 = new OuterClass().new InnerClass2();
        // 方位非静态内部类的成员需要使用非静态内部类的实例
        System.out.println(inner2.name2);
        inner2.display();
    }

    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
        outer.display();
    }
}