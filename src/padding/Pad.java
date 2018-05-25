package padding;

import java.io.UnsupportedEncodingException;

public class Pad {

    public static final String LPAD = "L";
    public static final String RPAD = "R";

    private static String paddingStr;
    private static String encoding;
    private static byte[] srcArr;
    private static byte[] rtnArr;
    private static int reqSize;

    /** 기본 데이터 타입에 따라 처리
     * 숫자의 경우 기본적으로 우측정렬하고 문자는 좌측정렬
     * @param pSrc(문자열)
     * @param pType (상수로 변경)
     * @param reqSize (크기)
     * @param encoding(인코딩)
     * @param paddingStr (채울문자)
     * @return String
     * @throws Exception
     *
     * */
    public static String pad(String pSrc, String pType, int reqSize, String encoding, String paddingStr) throws Exception {
        Pad.encoding = encoding;
        Pad.paddingStr = paddingStr;
        Pad.rtnArr = new byte[reqSize];
        Pad.srcArr = pSrc.getBytes(encoding);
        Pad.reqSize = reqSize;

        if (isGreaterThanDataSize(reqSize, srcArr.length)) {
            return getCutedEncodedStr();
        } else if (!isGreaterThanDataSize(reqSize, srcArr.length)) {
            switch (pType) {
                case LPAD :
                    return getLpadedEncodedStr();
                case  RPAD:
                    return getRpadedEncodedStr();
                default:
                    throw new Exception();
            }
        }
        return "";
    }

    private static String getRpadedEncodedStr () throws UnsupportedEncodingException {
        for (int idx = 0; idx < reqSize; idx++) {
            rtnArr[idx] = getEncodedPaddingByte();
        }
        if (srcArr != null) {
            for (int idx = 0; idx<srcArr.length; idx++) {
                rtnArr[idx] = srcArr[idx];
            }
        }
        return new String(rtnArr, encoding);
    }

    private static String getLpadedEncodedStr () throws UnsupportedEncodingException {
        for (int idx = 0; idx < reqSize - srcArr.length; idx++) {
            rtnArr[idx] = getEncodedPaddingByte();
        }
        if (srcArr != null) {
            for (int idx2 = srcArr.length-1; idx2 >= 0; idx2--) {
                reqSize--;
                for (int idx = reqSize; idx > reqSize-1 ; idx--) {
                    rtnArr[idx] = srcArr[idx2];
                }
            }
        }
        return new String(rtnArr, encoding);
    }

    private static String getCutedEncodedStr() throws UnsupportedEncodingException {
        for (int i=0; i<reqSize; i++) {
            rtnArr[i] = srcArr[i];
        }
        return new String(rtnArr, encoding);
    }

    private static boolean isGreaterThanDataSize(int reqSize, int dataSize) {
        return dataSize > reqSize;
    }

    private static byte getEncodedPaddingByte() throws UnsupportedEncodingException {
        return paddingStr.getBytes(encoding)[0];
    }

}

