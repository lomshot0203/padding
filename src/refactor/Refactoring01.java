package refactor;

public class Refactoring01 {

    private int _quantity;
    private int _itemPrice;

    /**
     *  수식을 변수로 대체한다.
     * */
    public  double priceToValue () {
        return _quantity * _itemPrice -
                Math.max(0, _quantity - 500) * _itemPrice * 0.05 +
                Math.min(_quantity * _itemPrice * 0.01, 100.0);
    }

    /* _quantity * _itemPrice를 변수basePrice로 대체한다.*/
    public  double priceToValue01 () {
        final double basePrice = _quantity * _itemPrice;
        return basePrice -
                Math.max(0, _quantity - 500) * _itemPrice * 0.05 +
                Math.min(basePrice * 0.01, 100.0);
    }

    /* _quantity * _itemPrice를 변수basePrice로 대체한다.*/
    public  double priceToValue02 () {
        final double basePrice = _quantity * _itemPrice;
        final double quantityDiscount = Math.max(0, _quantity - 500) * _itemPrice * 0.05;
        return basePrice - quantityDiscount +
                Math.min(basePrice * 0.01, 100.0);
    }

    public  double priceToValue03 () {
        final double basePrice = _quantity * _itemPrice;
        final double quantityDiscount = Math.max(0, _quantity - 500) * _itemPrice * 0.05;
        final double shipping = Math.min(basePrice * 0.01, 100.0);
        return basePrice - quantityDiscount + shipping;
    }

    /**
     *  수식을 메소드로 대체한다.
     * */
    public  double priceToMethod () {
        return _quantity * _itemPrice -
                Math.max(0, _quantity - 500) * _itemPrice * 0.05 +
                Math.min(_quantity * _itemPrice * 0.01, 100.0);
    }

    public double priceToMethod01 () {
        return basePrice() - quantityDiscount() + shipping();
    }

    private double shipping() {
        return Math.min(_quantity * _itemPrice * 0.01, 100.0);
    }

    private double quantityDiscount() {
        return Math.max(0, _quantity - 500) * _itemPrice * 0.05;
    }

    private double basePrice() {
        return _quantity * _itemPrice;
    }


    public class SplitTemporaryVariable{
        /**
         *  임시변수분리
         *  - 동일 임시변수에 값이 여러번 대입된다면 변수를 분리한다.
         * */
        private double _height;
        private double _width;
        private double _primaryForce;
        private double _secondaryForce;
        private double _mass;
        private int _delay;

        public void exam01 () {
            double temp = 2 * (_height + _width);
            System.out.println(temp);
            temp = _height * _width;
            System.out.println(temp);
        }

        public void exam02 () {
            double temp = 2 * (_height + _width);
            System.out.println(temp);
            double area = _height * _width;
            System.out.println(area);
        }

        public double getDistanceTravelled (int time) {
            double result;
            double acc = _primaryForce / _mass;
            int primaryTime = Math.min(time, _delay);
            result = 0.5 * acc * primaryTime * primaryTime;
            int secondaryTime = time - _delay;
            if (secondaryTime > 0) {
                double primaryVel = acc * _delay;
                acc = (_primaryForce + _secondaryForce) / _mass;
                result += primaryVel * secondaryTime + 0.5 + acc + secondaryTime * secondaryTime;
            }
            return result;
        }

        public double getDistanceTravelled01 (int time) {
            double result;
            final double primaryAcc = _primaryForce / _mass;
            int primaryTime = Math.min(time, _delay);
            result = 0.5 * primaryAcc * Math.pow(primaryTime, 2);
            int secondaryTime = time - _delay;
            if (secondaryTime > 0) {
                double primaryVel = primaryAcc * _delay;
                double acc = (_primaryForce + _secondaryForce) / _mass;
                result += primaryVel * secondaryTime + 0.5 + acc + Math.pow(secondaryTime, 2);
            }
            return result;
        }

        public double getDistanceTravelled02 (int time) {
            double result;
            final double primaryAcc = _primaryForce / _mass;
            int primaryTime = Math.min(time, _delay);
            result = 0.5 * primaryAcc * Math.pow(primaryTime, 2);
            int secondaryTime = time - _delay;
            if (secondaryTime > 0) {
                double primaryVel = primaryAcc * _delay;
                final double secondaryAcc = (_primaryForce + _secondaryForce) / _mass;
                result += primaryVel * secondaryTime + 0.5 + secondaryAcc + Math.pow(secondaryTime, 2);
            }
            return result;
        }
    }


    public class removeAssignmentsToParameters {
        /**
         *  매개변수로의 값 대입 제거
         *  - 값을 매개변수로 값을 받는 경우 매개변수 대신 임시변수를 사용한다.
         * */
        public int discount (int inputVal, int quantity, int yearToDate) {
            if (inputVal > 50) {
                inputVal -= 2;
            }
            if (quantity > 100) {
                inputVal -= 1;
            }
            if (yearToDate > 10000) {
                inputVal -= 4;
            }
            return inputVal;
        }

        public int discount01 (final int inputVal, final int quantity, final int yearToDate) {
            int result = inputVal;
            if (inputVal > 50) {
                result -= 2;
            }
            if (quantity > 100) {
                result -= 1;
            }
            if (yearToDate > 10000) {
                result -= 4;
            }
            return result;
        }
    }

    /** 매개변수 세트를 메서드로 전환
     *
     * */

    public class ReplaceParameterWithMethod01 {

        public double getPrice () {
            int basePrice = _quantity * _itemPrice; /** 메서드로 추출한다.*/
            int discountLevel;
            if (_quantity > 100) {
                discountLevel = 2;
            } else {
                discountLevel = 1;
            }
            double finalPrice = discountedPrice(basePrice, discountLevel);
            return finalPrice;
        }

        private double discountedPrice (int basePrice, int discountLevel) {
            if (discountLevel == 2) {
                return basePrice * 0.1;
            } else {
                return basePrice * 0.05;
            }
        }
    }

    /** 매개변수 세트를 메서드로 전환02*/
    public class ReplaceParameterWithMethod02 {

        public double getPrice () {
            return discountedPrice();
        }

        private int getBasePrice () {
            return _quantity * _itemPrice;
        }

        private int getDiscountLevel () {
            if (_quantity > 100) {
                return 2;
            } else {
                return 1;
            }
        }

        private double discountedPrice () {
            if (getDiscountLevel() == 2) {
                return getBasePrice() * 0.1;
            } else {
                return getBasePrice() * 0.05;
            }
        }
    }

}
