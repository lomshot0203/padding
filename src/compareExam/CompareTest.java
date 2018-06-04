package compareExam;

import java.util.*;

public class CompareTest {

    public static void main(String[] args) {
        /*String[] arr = new String[]{"b", "c", "a", "f", "g", "d", "e"};
        for (String str : arr) {
            System.out.print(str +" ");
        }

        printCarrageRetrun();
        Arrays.sort(arr);

        for (String str : arr) {
            System.out.print(str +" ");
        }*/

        ArrayList<VirAccVO> list = new ArrayList<>();
        list.add(new VirAccVO(2222));
        list.add(new VirAccVO(1123));
        list.add(new VirAccVO(2345));
        list.add(new VirAccVO(5435));

        printList(list);

        Collections.sort(list, new Comparator<VirAccVO>() {
            @Override
            public int compare(VirAccVO o1, VirAccVO o2) {
                if ( o1.getAccNo() > o2.getAccNo() ) {
                    return 1;
                } else if ( o1.getAccNo() < o2.getAccNo() ) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        printCarrageRetrun();
        printList(list);

    }

    private static void printList (Collection<VirAccVO> list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            it.next().toString();
        }
    }

    private static void printCarrageRetrun () {
        System.out.println();
    }
}
