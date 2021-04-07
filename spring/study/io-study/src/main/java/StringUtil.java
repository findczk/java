
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author 段顺兴
 * @version 1.0
 * @date 2020/4/22 17:48
 * @describe
 */
public class StringUtil {
    public static boolean isEmpty(String s) {
        if (s == null) return true;
        return s.trim().length() == 0;
    }

    public static boolean isNotEmpty(String s) {
        return !isEmpty(s);
    }


    public static String removeSpace(String s) {
        if (isEmpty(s)) {
            return s;
        }

        String[] split = s.split(",");
        Set<String> set = new HashSet<>(Arrays.asList(split));

        set.remove("");
        return String.join(",", set);
    }

    public static String format(String s) {
        if (isEmpty(s)) {
            return null;
        }
        return s;
    }
}
