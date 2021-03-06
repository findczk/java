package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 68. 文本左右对齐
 * 给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
 *
 * 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
 *
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 *
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 *
 * 说明:
 *
 * 单词是指由非空格字符组成的字符序列。
 * 每个单词的长度大于 0，小于等于 maxWidth。
 * 输入单词数组 words 至少包含一个单词。
 * @author dsx
 */
public class Solution68 {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int start = 0;

        while (start < words.length) {
            String str = words[start];
            int len = str.length();
            int end = ++start;
            while (end < words.length && (len + words[end].length() + 1) <= maxWidth) {
                len += words[end].length() + 1;
                end++;
            }
            int wordNumber = end - start;
            int spaceNumber = maxWidth - len + wordNumber;

            //最后一行
            if (end == words.length) {
                for (int i = start; i < end; i++) {
                    str += " " + words[i];
                }
                for (int i = 0; i < spaceNumber - (end - start); i++) {
                    str += " ";
                }
                res.add(str);
                break;
            }

            if (wordNumber == 0) {
                for (int i = 0; i < spaceNumber; i++) {
                    str += " ";
                }
            }else {
                String[] spaceArr = new String[wordNumber];
                for (int i = 0; i < spaceNumber; i++) {
                    spaceArr[i % wordNumber] = spaceArr[i % wordNumber] == null ? " " : spaceArr[i % wordNumber] + " ";
                }

                for (int i = start; i < end; i++) {
                    str += spaceArr[i - start] + words[i];
                }
            }

            res.add(str);
            start = end;
        }
        return res;
    }
}
