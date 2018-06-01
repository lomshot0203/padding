package refactor;

public class Account {

    private AccountType _type;
    private int _daysOverdrawn;

    public double overdraftCharge () {
        if (_type.isPremium()) {
            double result = 10;
            if (_daysOverdrawn > 7) {
                result += (_daysOverdrawn - 7) * 0.85;
                return result;
            }
        } else {
            return _daysOverdrawn * 1.75;
        }
        return 0.0;
    }

    public double bankCharge () {
        double result = 4.5;
        if (_daysOverdrawn > 0) {
            result += overdraftCharge();
        }
        return result;
    }
}
