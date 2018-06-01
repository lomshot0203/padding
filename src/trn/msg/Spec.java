package trn.msg;

import java.util.List;

public abstract class Spec {

    private String seq;  /*순번 */
    private String nm;  /*이름*/
    private String idNm;  /*아이디호칭*/
    private String columnNm;  /*컬럼호칭*/
    private String begPoint;  /*시작점*/
    private String endPoint;  /*종국점*/
    private String dataSize;  /*데이터크기*/
    private String dataType;  /*데이터타입*/

    private List<Spec> specs;

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getNm() {
        return nm;
    }

    public void setNm(String nm) {
        this.nm = nm;
    }

    public String getIdNm() {
        return idNm;
    }

    public void setIdNm(String idNm) {
        this.idNm = idNm;
    }

    public String getColumnNm() {
        return columnNm;
    }

    public void setColumnNm(String columnNm) {
        this.columnNm = columnNm;
    }

    public String getBegPoint() {
        return begPoint;
    }

    public void setBegPoint(String begPoint) {
        this.begPoint = begPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public String getDataSize() {
        return dataSize;
    }

    public void setDataSize(String dataSize) {
        this.dataSize = dataSize;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public List<Spec> getSpecs() {
        return specs;
    }

    public void setSpecs(List<Spec> specs) {
        this.specs = specs;
    }
}
