import Utils.*;

import java.text.NumberFormat;

public class test {
    public static void main(String[] args) {
        /*
        * 源论文路径
        * */
        String textPath="src/main/resources/OriginalTxt";
        /*
        * 写入结果路径
        * */
        String writePath="src/main/resources/Result";
        String str1=IOUtil.readTxt(textPath);
        NumberFormat nf=NumberFormat.getPercentInstance();
        nf.setMaximumFractionDigits(2);

        for (int i=1;i<=5;i++){
            /*
            * 各种抄袭论文路径
            * */
            String textPath1="src/main/resources/CopyTxt";
            textPath1+=i;
            System.out.println(textPath1);
            String str2=IOUtil.readTxt(textPath1);
            double similarity = CheckUtil.getSimilarity(str1, str2);
            String format = nf.format(similarity);
            String str="第"+i+"篇文章与原文的相似程度为："+format;
            System.out.println("该文章与原文的相似程度为："+format);
            IOUtil.writeTxt(str,writePath);
        }
    }
}
