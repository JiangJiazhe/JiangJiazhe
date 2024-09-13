package Utils;

public class CheckUtil {
    /**
     * 计算并返回两个字符串之间的相似度。
     * 使用SimHash算法来生成两个字符串的哈希值，然后计算这两个哈希值之间的汉明距离，
     * 最后根据汉明距离计算相似度。
     *
     * @param str1 第一个字符串
     * @param str2 第二个字符串
     * @return 返回一个介于0和1之间的double值，表示两个字符串的相似度。
     *         值越接近1，表示相似度越高；值越接近0，表示相似度越低。
     */
    public static double getSimilarity(String str1,String str2){
        String simHash = SimHashUtil.getSimHash(str1);
        String simHash5 = SimHashUtil.getSimHash(str2);
        int hammingDistance = HammingUtil.getHammingDistance(simHash, simHash5);
        double similarity = HammingUtil.getSimilarity(hammingDistance);
        return similarity;
    }
}

