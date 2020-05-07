package emoji;

/**
 * @ClassName EmojiUtil
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2020/5/6 15:05
 * @Version 1.0
 */
public class EmojiUtil {


    /**
     * emoji表情替换
     *
     * @param source 原字符串
     * @param slipStr emoji表情替换成的字符串
     * @return 过滤后的字符串
     */
    public static String filterEmoji(String source,String slipStr) {
       return source.replaceAll("[\\ud800\\udc00-\\udbff\\udfff\\ud800-\\udfff]", slipStr);

    }
}
