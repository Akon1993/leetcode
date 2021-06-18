package 剑指Offer;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 */
public class A005_replaceSpace {
    public static void main(String[] args) {
        String s = "We are happy.";
        System.out.println(replaceSpace(s));
    }

    public static String replaceSpace(String s) {
        if (s != null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (' ' == ch) {
                    sb.append("%20");
                } else {
                    sb.append(ch);
                }
            }
            return sb.toString();
        }
        return null;
    }

    public static String replaceSpace_0(String s) {
        if (s != null) {
            return s.replace(" ", "%20");
        }
        return null;
    }
}
