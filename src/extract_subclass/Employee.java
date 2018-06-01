package extract_subclass;

public class Employee {
    private int _rate;
    private String _name;

    public Employee(int rate) {
        this._rate = rate;
    }

    public Employee(String name) {
        this._name = name;
    }

    public int getRate() {
        return _rate;
    }
}
