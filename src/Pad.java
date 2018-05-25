public class Pad {

    /** 기본 데이터 타입에 따라 처리
     * 숫자의 경우 기본적으로 우측정렬하고 문자는 좌측정렬
     * @param pSrc(문자열)
     * @param pType (string,number)
     * @param pSize (크기)
     * @param encoding(인코딩)
     * @param zeroYn (숫자의 경우 공백으로 빈칸을 채우려면 N 아니면 Y)
     * @return String
     * @throws Exception
     *
     * */
    public static String pad(String pSrc, String pType, String pSize, String encoding, String zeroYn) throws Exception {
        int dataLen = 0;
        int size = Integer.parseInt(pSize); /*요구 데이터 길이*/
        byte[] src = null; /*실데이터*/
        byte[] temp = new byte[size]; /*리턴용 배열*/
        String type = pType.toLowerCase(); /*타입*/
        byte[] space = new String(" ").getBytes(encoding);
        byte[] zero = null;
        if ("Y".equals(zeroYn)) {
            zero = new String("0").getBytes(encoding);
        } else if ("N".equals(zeroYn)) {
            zero = new String(" ").getBytes(encoding);
        }
        String rtnStr = "";
        if (pSrc != null) {
            src = pSrc.getBytes(encoding);
            dataLen = src.length;
        }

        if (size < dataLen) {
            byte[] tmpByte = new byte[size];
            for (int i=0; i<size; i++) {
                tmpByte[i] = src[i];
            }
            src = null;
            src = tmpByte;
        }

        if (size >= dataLen) {
            if ("number".equals(type)) {
                for (int idx = 0; idx < size - dataLen; idx++) {
                    temp[idx] = zero[0];
                }
                if (src != null) {
                    for (int idx2 = dataLen-1; idx2 >= 0; idx2--) {
                        size--;
                        for (int idx = size; idx > size-1 ; idx--) {
                            temp[idx] = src[idx2];
                        }
                    }
                }
            }

            if ("string".equals(type)) {
                for (int idx = 0; idx < size; idx++) {
                    temp[idx] = space[0];
                }
                if (src != null) {
                    for (int idx = 0; idx<dataLen; idx++) {
                        temp[idx] = src[idx];
                    }
                }
            }
        }
        rtnStr = new String(temp, encoding);
        return rtnStr;
    }
}

