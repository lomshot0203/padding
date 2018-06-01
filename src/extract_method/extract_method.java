package extract_method;

import javax.lang.model.util.Elements;
import java.util.*;

public class extract_method {

    /**
     * 1.임시변수가 추출한 코드 안에서 사용되는 경우
     * 2.임시변수가 추출한 코드 밖에서 사용되는 경우
     * */

    Vector _orders;
    String _name;

    void printOwing () {

        printBanner();
        double outstanding = getOutStanding();

        printDetails(outstanding);

    }

    private double getOutStanding () {
        double result = 0.0;
        Enumeration e = _orders.elements();
        while (e.hasMoreElements()) {
            Order each = (Order)e.nextElement();
            result += each.getAmount();
        }
        return result;
    }

    private void printDetails(double outstanding) { /*세부내역 출력*/
        System.out.println("고객명 : " + _name);
        System.out.println("외상액 : " + outstanding);
    }

    private void printBanner() { /*배너출력*/
        System.out.println("********************");
        System.out.println("******고객외상******");
        System.out.println("********************");
    }
}
