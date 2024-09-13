package Utils;

public class HammingUtil {
    /**
     * 计算并返回两个字符串（假设为哈希值）之间的汉明距离。
     * 汉明距离是两个等长字符串对应位置上不同字符的个数。
     * 如果两个字符串长度不等，则返回-1表示无法计算汉明距离。
     *
     * @param simHash1 第一个字符串（哈希值）
     * @param simHash2 第二个字符串（哈希值）
     * @return 如果两个字符串长度相等，则返回它们之间的汉明距离；否则返回-1。
     */

    public static int getHammingDistance(String simHash1, String simHash2){
       if(simHash1.length()!=simHash2.length())
           return -1;
       int distance=0;
       System.out.println("str1的simHash值："+simHash1);
       System.out.println("str2的simHash值："+simHash2);
       for (int i=0;i<simHash1.length();i++){
           if(simHash1.charAt(i)!=simHash2.charAt(i))
               distance++;

       }
       System.out.println("海明距离为："+distance);
       return distance;
   }

   public static double getSimilarity(int distance){

       return 1-distance/128.0;
   }

}



