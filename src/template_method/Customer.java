package template_method;

import template_method.Rental;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {

    private Vector _rentals = new Vector();
    private String _name;

    public Customer(String _name) {
        this._name = _name;
    }

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName() {
        return _name;
    }

    public String statement () {
        Enumeration rentals = _rentals.elements();
        String result = getName() + "고객님의 대여기록\n";
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            /*이번에 대여하는 비디오정보와 대여료를 출력*/
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
        }
        // 푸터 행추가
        result += "누적 대여료: " + String.valueOf(getTotalCharge()) + "\n";
        result += "적립 포인트: " + String.valueOf(getFrequentRenterPoints());
        return result;
    }

    private double getTotalCharge () {
        double result = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getCharge();
        }
        return result;
    }

    private double getFrequentRenterPoints () {
        double result = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }

}
