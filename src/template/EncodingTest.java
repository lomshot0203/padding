package template;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class EncodingTest {
    public static void main(String[] args) {
        String str = "가나다하";
        List<Byte> list = new ArrayList<>();
        try {
            for (byte bb : str.getBytes("KSC5601")){
                list.add(bb);
            }
        } catch (UnsupportedEncodingException e) {
            System.out.println("지원하지 않는 인코딩형식입니다.");
        }
        System.out.println();

        String[] row = new String[3];
        row[0] = "LiverPool";
        row[1] = "15";
        String[] aa = new String[Integer.parseInt("a")];
    }

    /*static {
        System.out.println("클래스초기화");
    }

    {
        System.out.println("인스턴스 초기화");
    }

    public static void main(String[] args) {
        new EncodingTest();
        new EncodingTest();
    }*/

}
