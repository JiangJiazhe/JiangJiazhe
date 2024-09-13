package Utils;

import com.hankcs.hanlp.HanLP;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;

public class SimHashUtil {

    public static String getHash(String str) {
        try {
            // 这里使用了MD5获得hash值
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            return new BigInteger(1, messageDigest.digest(str.getBytes("UTF-8"))).toString(2);
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public static String getSimHash(String str) {
        if (str.length() < 66) {
            System.out.println("输入文本过短");
        }
        int[] weight = new int[128];
        List<String> keywordList = HanLP.extractKeyword(str, str.length());
        int size = keywordList.size();
        int i = 0;
        for (String keyword : keywordList) {
            String hash = getHash(keyword);
            if (hash.length() < 128) {
                int distance = 128 - hash.length();
                for (int j = 0; j < distance; j++) {
                    hash += "0";
                }
            }
            for (int j = 0; j < weight.length; j++) {
                if (hash.charAt(j) == '1') {
                    weight[j] += (10 - (i / (size / 10)));
                } else {
                    weight[j] -= (10 - (i / (size / 10)));
                }
            }
            i++;
        }
        String simHash = "";
        for (int j = 0; j < weight.length; j++) {
            if (weight[j] > 0) {
                simHash += "1";
            } else simHash += "0";
        }
        return simHash;

    }


}
