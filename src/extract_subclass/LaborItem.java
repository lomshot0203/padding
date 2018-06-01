package extract_subclass;

public class LaborItem extends JobItem{

    public LaborItem(int unitPrice, int quantity, boolean isLabor, Employee employee) {
        super(0, quantity, isLabor);
        _employee = employee;
    }

    @Override
    public int getUnitPrice() {
        return _employee.getRate();
    }

    @Override
    public Employee getEmployee() {
        return _employee;
    }

    @Override
    protected boolean isLabor() {
        return true;
    }
}
