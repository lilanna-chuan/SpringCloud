package emoji;

import com.vdurmont.emoji.EmojiParser;

import java.util.Collections;

/**
 * @ClassName Solution
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2020/4/28 13:59
 * @Version 1.0
 */
public class Solution {


    public static void main(String[] args) {
        String str="開開心\uD83E\uDD2D";

        String result= EmojiParser.parseToAliases(str);
        System.out.println(result);
        String res=EmojiParser.parseToUnicode(result);
        System.out.println(res);
    }
}
