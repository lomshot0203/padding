package innerClass;

public class OutterClass {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void callClass () {
        System.out.println("call~~"+name+"...class");
    }

    private class InnerClass {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void callClass () {
            System.out.println("call~~"+name+"...class");
        }
    }

    public static void main(String[] args) {
        OutterClass outter = new OutterClass();
        outter.setName("outer");
        outter.callClass();

        OutterClass.InnerClass inner = outter.new InnerClass();
        inner.setName("inner");
        inner.callClass();
    }

}
