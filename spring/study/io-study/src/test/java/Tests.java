import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.IOUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author dsx
 */
public class Tests {
    private long start;
    private long end;

    @Before
    public void start() {
        start = System.currentTimeMillis();
    }

    @Test
    public void test() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\lg\\Desktop\\1.json");
        String s = IOUtils.toString(fileInputStream, "UTF-8");
        Foo foo = JSON.parseObject(s, Foo.class);

        Map<String, List<AuthManager>> map = new HashMap<>();
        List<AuthManager> records = foo.getRECORDS();
        for (AuthManager record : records) {
            String fkDrugInfoList = record.getFkDrugInfoList();
            List<String> list = Arrays.asList(StringUtil.removeSpace(fkDrugInfoList).split(","));
            for (String s1 : list) {
                if (map.containsKey(s1)) {
                    List<AuthManager> list1 = map.get(s1);
                    list1.add(record);
                    map.put(s1, list1);
                }else {
                    List<AuthManager> objects = new ArrayList<>();
                    objects.add(record);
                    map.put(s1, objects);
                }
            }

        }

        for (Map.Entry<String, List<AuthManager>> entry : map.entrySet()) {
            if (entry.getValue().size() > 1) {
                List<AuthManager> value = entry.getValue();
                String str = "";
                for (AuthManager authManager : value) {
                    str += "、" + authManager.getUnit();
                }
                System.out.println(entry.getKey() + ":" + str);
            }
        }
    }

    @After
    public void after() {
        end = System.currentTimeMillis();
        System.out.println(end-start);
    }


}
