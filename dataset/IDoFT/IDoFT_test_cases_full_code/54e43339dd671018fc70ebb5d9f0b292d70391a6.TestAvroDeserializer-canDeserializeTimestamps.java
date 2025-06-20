/** 
 * Test whether Avro timestamps can be deserialized according to new behavior (storage in UTC but LocalDateTime semantics as timestamps are converted back to the writer time zone) as well as old behavior (Instant semantics).
 */
@Test public void canDeserializeTimestamps() throws SerDeException, IOException {
  List<String> columnNames=new ArrayList<>();
  columnNames.add("timestampField");
  List<TypeInfo> columnTypes=new ArrayList<>();
  columnTypes.add(TypeInfoFactory.getPrimitiveTypeInfo("timestamp"));
  Schema readerSchema=AvroSerdeUtils.getSchemaFor(TestAvroObjectInspectorGenerator.TIMESTAMP_SCHEMA);
  GenericData.Record record=new GenericData.Record(readerSchema);
  record.put("timestampField",1546387200999L);
  assertTrue(GENERIC_DATA.validate(readerSchema,record));
  AvroGenericRecordWritable agrw=new AvroGenericRecordWritable(ZoneId.of("America/New_York"),false,false);
  agrw.setRecord(record);
  agrw.setFileSchema(readerSchema);
  agrw.setRecordReaderID(new UID());
  AvroDeserializer deserializer=new AvroDeserializer();
  ArrayList<Object> row=(ArrayList<Object>)deserializer.deserialize(columnNames,columnTypes,agrw,readerSchema);
  Timestamp resultTimestamp=(Timestamp)row.get(0);
  assertEquals(Timestamp.valueOf("2019-01-01 19:00:00.999"),resultTimestamp);
  AvroGenericRecordWritable agrw2=new AvroGenericRecordWritable();
  agrw2.setRecord(record);
  agrw2.setFileSchema(readerSchema);
  agrw2.setRecordReaderID(new UID());
  row=(ArrayList<Object>)deserializer.deserialize(columnNames,columnTypes,agrw2,readerSchema);
  resultTimestamp=(Timestamp)row.get(0);
  assertEquals(Timestamp.valueOf("2019-01-01 16:00:00.999"),resultTimestamp);
}
