package padding;

public class TestMain {
    public static void main(String[] args) throws Exception {
//        System.out.println(padding.Pad.pad("최원영", "number", "30", "ksc5601", "Y"));
        System.out.println(Pad.pad("최원영", Pad.LPAD, 3, "ksc5601", "0"));

    }
}