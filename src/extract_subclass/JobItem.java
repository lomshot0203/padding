package extract_subclass;

/**
 * 작업종류별 가격을 구한다.
 * */
public class JobItem {
    int _unitPrice;
    int _quantity;
    protected Employee _employee;

    protected JobItem(int unitPrice, int quantity, boolean isLabor) {
        _unitPrice = unitPrice;
        _quantity = quantity;
    }

    public JobItem(int _unitPrice, int _quantity) {
        this (_unitPrice, _quantity, false);
    }

    public int getTotalPrice() {
        return getUnitPrice() * _quantity;
    }

    public int getUnitPrice() {
        return (isLabor()) ? _employee.getRate() : _unitPrice;
    }

    public int getQuantity() {
        return _quantity;
    }

    public Employee getEmployee() {
        return _employee;
    }

    protected boolean isLabor() {
        return false;
    }
}
