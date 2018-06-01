package constructClassForName;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class testMain {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        String classNm = "constructClassForName";
        Class cls = Class.forName(classNm);
        Object obj = cls.newInstance();
        Method m = cls.getDeclaredMethod("test", String.class, String.class);
        m.invoke(obj, "파라미터1", "파라미터2");
    }
}
