public class TestMain {
    public static void main(String[] args) throws Exception {
        System.out.println(Pad.pad("최원영", "number", "30", "ksc5601", "Y"));
        System.out.println(Pad.pad("최원영", Pad.RPAD, "30", "ksc5601", "Y"));

    }
}
