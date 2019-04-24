package cn.zz.util;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @Auther: ZhangZhuo
 * @Date: 2019/4/24 15:15
 * @Description: 通过时间戳生成随机数
 */
public class RandomString {

    private static final String DF_LONG_DATE2 = "yyyyMMddHHmmssSSS";

    /**
     * 获取UUID
     *
     * @return
     */
    public static String getGUID() {
        UUID guid = UUID.randomUUID();
        return guid.toString();
    }

    /**
     * 返回长度为【pLength】的随机数  获取定长的随机数
     *
     * @param pLength
     * @return
     */
    public static final String getRandom(int pLength) {
        String random = "";
        for (int i = 0; i < pLength; i++) {
            int t = (int) (java.lang.Math.random() * 10);
            random += String.valueOf(t);
        }
        return random;
    }

    /**
     * 通过时间戳生成随机数 精确到毫秒(17位)
     *
     * @return
     */
    public static String getTimeSequence() {
        SimpleDateFormat formater = new SimpleDateFormat(DF_LONG_DATE2);
        String Sequence = formater.format(new Date());
        //Sequence += getRandom(5);  //如实际需要可在随机数后拼接定长随机数
        return Sequence;
    }

    public static void main(String[] ages) {
        String random = getRandom(3);
        String timeSequence = getTimeSequence();
        System.out.println("获取定长随机数 : " + random + " 随机数长度 : " + random.length());
        System.out.println("获取时间戳随机数 : "+timeSequence+" 长度 : "+timeSequence.length());
        System.out.println(timeSequence+random);
    }
}
