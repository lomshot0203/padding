package template;

import java.lang.reflect.Array;
import java.util.*;

public class Template {
    public static void main(String[] args) throws Exception{

        System.out.println(lpad("최원영", 30, "0", "MS949"));
        System.out.println(rpad("최원영", 30, "0", "MS949"));
    }

    private static String lpad(String src, int SrcSize, String pPad, String encoding) throws Exception{
        int srcSize = 30;
        byte[] pad = new String(pPad).getBytes(encoding);

        byte[] paramArr = src.getBytes(encoding);
        byte[] rtnArr = new byte[srcSize];

        if (rtnArr.length >= paramArr.length) {
            /* 리턴데이터가 파라미터 사이즈 보다 긴경우
            *  파라미터 길이만큼 배열을 파라미터로 채우고 나머지는 패딩값으로 채운다.
            * */
            int idx = 0;
            while (true) {
                if (idx == paramArr.length) {
                    break;
                }
                rtnArr[idx] = paramArr[idx];
                idx++;
            }
            while (true) {
                if (idx == rtnArr.length) {
                    break;
                }
                rtnArr[idx] = pad[0];
                idx++;
            }

        } else {
            for (int idx=0; idx < rtnArr.length; idx++) {
                rtnArr[idx] = paramArr[idx];
            }
        }

        return new String(rtnArr, encoding);
    }

    private static String rpad(String src, int SrcSize, String pPad, String encoding) throws Exception {
        int srcSize = 30;
        byte[] pad = new String(pPad).getBytes(encoding);

        byte[] paramArr = src.getBytes(encoding);
        byte[] rtnArr = new byte[srcSize];

        if (rtnArr.length >= paramArr.length) {
            /* 리턴데이터가 파라미터 사이즈 보다 긴경우
            *  파라미터 길이만큼 배열을 파라미터로 채우고 나머지는 패딩값으로 채운다.
            * */
          for (int idx = 0; idx < paramArr.length; idx++) {
              rtnArr[ rtnArr.length - paramArr.length + idx] = paramArr[idx];
          }
          for (int idx=0; idx < (rtnArr.length - paramArr.length); idx++) {
              rtnArr[idx] = pad[0];
          }
        } else {
            for (int idx=0; idx < paramArr.length; idx++) {
                rtnArr[idx] = paramArr[idx];
            }
        }

        return new String(rtnArr, encoding);
    }
}



