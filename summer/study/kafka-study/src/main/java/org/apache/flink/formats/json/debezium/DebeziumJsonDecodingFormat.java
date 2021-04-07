//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.apache.flink.formats.json.debezium;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.flink.api.common.serialization.DeserializationSchema;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.formats.json.TimestampFormat;
import org.apache.flink.formats.json.debezium.DebeziumJsonDeserializationSchema.MetadataConverter;
import org.apache.flink.table.api.DataTypes;
import org.apache.flink.table.api.DataTypes.Field;
import org.apache.flink.table.connector.ChangelogMode;
import org.apache.flink.table.connector.format.DecodingFormat;
import org.apache.flink.table.connector.source.DynamicTableSource.Context;
import org.apache.flink.table.data.GenericMapData;
import org.apache.flink.table.data.GenericRowData;
import org.apache.flink.table.data.RowData;
import org.apache.flink.table.data.StringData;
import org.apache.flink.table.data.TimestampData;
import org.apache.flink.table.types.DataType;
import org.apache.flink.table.types.utils.DataTypeUtils;
import org.apache.flink.types.RowKind;

public class DebeziumJsonDecodingFormat implements DecodingFormat<DeserializationSchema<RowData>> {
    private List<String> metadataKeys;
    private final boolean schemaInclude;
    private final boolean ignoreParseErrors;
    private final TimestampFormat timestampFormat;
    private static final StringData KEY_SOURCE_TIMESTAMP = StringData.fromString("ts_ms");
    private static final StringData KEY_SOURCE_DATABASE = StringData.fromString("db");
    private static final StringData KEY_SOURCE_SCHEMA = StringData.fromString("schema");
    private static final StringData KEY_SOURCE_TABLE = StringData.fromString("table");
    private static final StringData KEY_SOURCE_NAME = StringData.fromString("name");

    public DebeziumJsonDecodingFormat(boolean schemaInclude, boolean ignoreParseErrors, TimestampFormat timestampFormat) {
        this.schemaInclude = schemaInclude;
        this.ignoreParseErrors = ignoreParseErrors;
        this.timestampFormat = timestampFormat;
        this.metadataKeys = Collections.emptyList();
    }

    public DeserializationSchema<RowData> createRuntimeDecoder(Context context, DataType physicalDataType) {
        List<DebeziumJsonDecodingFormat.ReadableMetadata> readableMetadata = (List)this.metadataKeys.stream().map((k) -> {
            return (DebeziumJsonDecodingFormat.ReadableMetadata)Stream.of(DebeziumJsonDecodingFormat.ReadableMetadata.values()).filter((rm) -> {
                return rm.key.equals(k);
            }).findFirst().orElseThrow(IllegalStateException::new);
        }).collect(Collectors.toList());
        List<Field> metadataFields = (List)readableMetadata.stream().map((m) -> {
            return DataTypes.FIELD(m.key, m.dataType);
        }).collect(Collectors.toList());
        DataType producedDataType = DataTypeUtils.appendRowFields(physicalDataType, metadataFields);
        TypeInformation<RowData> producedTypeInfo = context.createTypeInformation(producedDataType);
        return new DebeziumJsonDeserializationSchema(physicalDataType, readableMetadata, producedTypeInfo, this.schemaInclude, this.ignoreParseErrors, this.timestampFormat);
    }

    public Map<String, DataType> listReadableMetadata() {
        Map<String, DataType> metadataMap = new LinkedHashMap();
        Stream.of(DebeziumJsonDecodingFormat.ReadableMetadata.values()).forEachOrdered((m) -> {
            DataType var10000 = (DataType)metadataMap.put(m.key, m.dataType);
        });
        return metadataMap;
    }

    public void applyReadableMetadata(List<String> metadataKeys) {
        this.metadataKeys = metadataKeys;
    }

    public ChangelogMode getChangelogMode() {
        return ChangelogMode.newBuilder().addContainedKind(RowKind.INSERT).addContainedKind(RowKind.UPDATE_BEFORE).addContainedKind(RowKind.UPDATE_AFTER).addContainedKind(RowKind.DELETE).build();
    }

    private static Object readProperty(GenericRowData row, int pos, StringData key) {
        GenericMapData map = (GenericMapData)row.getMap(pos);
        return map == null ? null : map.get(key);
    }

    static enum ReadableMetadata {
        SCHEMA("schema", (DataType)DataTypes.STRING().nullable(), false, DataTypes.FIELD("schema", DataTypes.STRING()), new MetadataConverter() {
            private static final long serialVersionUID = 1L;

            public Object convert(GenericRowData row, int pos) {
                return row.getString(pos);
            }
        }),
        INGESTION_TIMESTAMP("ingestion-timestamp", (DataType)DataTypes.TIMESTAMP_WITH_LOCAL_TIME_ZONE(3).nullable(), true, DataTypes.FIELD("ts_ms", DataTypes.BIGINT()), new MetadataConverter() {
            private static final long serialVersionUID = 1L;

            public Object convert(GenericRowData row, int pos) {
                return row.isNullAt(pos) ? null : TimestampData.fromEpochMillis(row.getLong(pos));
            }
        }),
        SOURCE_TIMESTAMP("source.timestamp", (DataType)DataTypes.TIMESTAMP_WITH_LOCAL_TIME_ZONE(3).nullable(), true, DataTypes.FIELD("source", DataTypes.MAP(DataTypes.STRING(), DataTypes.STRING())), new MetadataConverter() {
            private static final long serialVersionUID = 1L;

            public Object convert(GenericRowData row, int pos) {
                StringData timestamp = (StringData)DebeziumJsonDecodingFormat.readProperty(row, pos, DebeziumJsonDecodingFormat.KEY_SOURCE_TIMESTAMP);
                return timestamp == null ? null : TimestampData.fromEpochMillis(Long.parseLong(timestamp.toString()));
            }
        }),
        SOURCE_DATABASE("source.database", (DataType)DataTypes.STRING().nullable(), true, DataTypes.FIELD("source", DataTypes.MAP(DataTypes.STRING(), DataTypes.STRING())), new MetadataConverter() {
            private static final long serialVersionUID = 1L;

            public Object convert(GenericRowData row, int pos) {
                return DebeziumJsonDecodingFormat.readProperty(row, pos, DebeziumJsonDecodingFormat.KEY_SOURCE_DATABASE);
            }
        }),
        SOURCE_SCHEMA("source.schema", (DataType)DataTypes.STRING().nullable(), true, DataTypes.FIELD("source", DataTypes.MAP(DataTypes.STRING(), DataTypes.STRING())), new MetadataConverter() {
            private static final long serialVersionUID = 1L;

            public Object convert(GenericRowData row, int pos) {
                return DebeziumJsonDecodingFormat.readProperty(row, pos, DebeziumJsonDecodingFormat.KEY_SOURCE_SCHEMA);
            }
        }),
        SOURCE_TABLE("source.table", (DataType)DataTypes.STRING().nullable(), true, DataTypes.FIELD("source", DataTypes.MAP(DataTypes.STRING(), DataTypes.STRING())), new MetadataConverter() {
            private static final long serialVersionUID = 1L;

            public Object convert(GenericRowData row, int pos) {
                return DebeziumJsonDecodingFormat.readProperty(row, pos, DebeziumJsonDecodingFormat.KEY_SOURCE_TABLE);
            }
        }),
        SOURCE_NAME("source.name", (DataType)DataTypes.STRING().nullable(), true, DataTypes.FIELD("source", DataTypes.MAP(DataTypes.STRING(), DataTypes.STRING())), new MetadataConverter() {
            private static final long serialVersionUID = 1L;

            public Object convert(GenericRowData row, int pos) {
                return DebeziumJsonDecodingFormat.readProperty(row, pos, DebeziumJsonDecodingFormat.KEY_SOURCE_NAME);
            }
        }),
        SOURCE_PROPERTIES("source.properties", (DataType)DataTypes.MAP((DataType)DataTypes.STRING().nullable(), (DataType)DataTypes.STRING().nullable()).nullable(), true, DataTypes.FIELD("source", DataTypes.MAP(DataTypes.STRING(), DataTypes.STRING())), new MetadataConverter() {
            private static final long serialVersionUID = 1L;

            public Object convert(GenericRowData row, int pos) {
                return row.getMap(pos);
            }
        });

        final String key;
        final DataType dataType;
        final boolean isJsonPayload;
        final Field requiredJsonField;
        final MetadataConverter converter;

        private ReadableMetadata(String key, DataType dataType, boolean isJsonPayload, Field requiredJsonField, MetadataConverter converter) {
            this.key = key;
            this.dataType = dataType;
            this.isJsonPayload = isJsonPayload;
            this.requiredJsonField = requiredJsonField;
            this.converter = converter;
        }
    }
}
