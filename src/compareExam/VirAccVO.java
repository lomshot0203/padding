package compareExam;

import java.util.Comparator;

public class VirAccVO {

    private int accNo;

    public VirAccVO (int accNo) {
        this.accNo = accNo;
    }

    public int getAccNo() {
        return accNo;
    }

    public void setAccNo(int accNo) {
        this.accNo = accNo;
    }

    @Override
    public String toString() {
        System.out.print(accNo+" ");
        return null;
    }
}
