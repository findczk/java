import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.table.api.EnvironmentSettings;
import org.apache.flink.table.api.SqlDialect;
import org.apache.flink.table.api.Table;
import org.apache.flink.table.api.TableResult;
import org.apache.flink.table.api.bridge.java.StreamTableEnvironment;
import org.apache.flink.types.Row;
import org.apache.flink.util.CloseableIterator;


/**
 * @description: TODO
 * @author: hze
 * @time: 2021 2021/3/18 上午9:31
 */
public class FlinkTable {

    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment ssEnv = StreamExecutionEnvironment.getExecutionEnvironment();
        EnvironmentSettings ssSettings = EnvironmentSettings.newInstance().useBlinkPlanner().inStreamingMode().build();
        StreamTableEnvironment ssTableEnv = StreamTableEnvironment.create(ssEnv, ssSettings);
        ssTableEnv.getConfig().setSqlDialect(SqlDialect.DEFAULT);
        String sql = "create table test_table ( \n" +
                    "`id` int,\n" +
                    "`fk_drug_info` int,\n" +
                    "`fk_professional_id` string,\n" +
                    "`urine_time` TIMESTAMP(3) METADATA FROM 'value.source.timestamp' VIRTUAL,\n" +
                    "`urine_place` string,\n" +
                    "`urine_result` int,\n" +
                    "`test_type` int,\n" +
                    "`test_time` TIMESTAMP(3) METADATA FROM 'value.source.timestamp' VIRTUAL,\n" +
                    "`seal_time` TIMESTAMP(3) METADATA FROM 'value.source.timestamp' VIRTUAL,\n" +
                    "`urine_image` string,\n" +
                    "`urine_video` string,\n" +
                    "`urine_cause` string,\n" +
                    "`help_professional_id` int,\n" +
                    "`latitude` string,\n" +
                    "`fk_auth_manager` int,\n" +
                    "`table_date` TIMESTAMP(3) METADATA FROM 'value.source.timestamp' VIRTUAL,\n" +
                    "`urine_state_type` int,\n" +
                    "`annex` string,\n" +
                    "`update_time` TIMESTAMP(3) METADATA FROM 'value.source.timestamp' VIRTUAL,\n" +
                    "`server_name` string METADATA FROM 'value.source.name' VIRTUAL,\n" +
                    "`is_del` int\n"+
                ") with ( \n" +
                    "'connector' = 'kafka',\n" +
//                    "'debezium-json.schema-include' = 'true',\n" +
                    "'topic' = 'lg831_sichuan.dbo.urine_upload',\n" +
                    "'properties.bootstrap.servers' = '192.168.1.110:9092',\n" +
                    "'scan.startup.mode' = 'earliest-offset',\n" +
                    "'properties.group.id' = 'urine_upload',\n" +
                    "'format' = 'debezium-json'"+
                ")";
        ssTableEnv.executeSql(sql);
        Table result = ssTableEnv.sqlQuery("select * from test_table");
        // 保存愿数据   异步关联hive数据库    进行数据打宽
        result.execute().print();
//        TableResult tableResult = result.execute();
//        CloseableIterator<Row> collect = tableResult.collect();
//        while (collect.hasNext()){
//            Row next = collect.next();
//            System.out.println(next.toString());
//        }
        ssEnv.execute();
    }
}
