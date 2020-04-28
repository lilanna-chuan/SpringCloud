package emoji;

import com.vdurmont.emoji.EmojiParser;

/**
 * @ClassName Solution
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2020/4/28 13:59
 * @Version 1.0
 */
public class Solution {


    public static void main(String[] args) {
        String str="阿萨啊/小纠结/流泪/小纠结/doge/难过发放时格式格式";
        String result= EmojiParser.parseToAliases(str);
        System.out.println(result);

        String res=EmojiParser.parseToUnicode(result);
        System.out.println(res);
    }
}
