@Test public void testInferTypeWithMapNonStringKeys(){
  Map<Integer,String> map=new HashMap<>();
  map.put(1,"Hello");
  map.put(2,"World");
  RecordDataType expected=(RecordDataType)RecordFieldType.RECORD.getRecordDataType(new SimpleRecordSchema(Arrays.asList(new RecordField("1",RecordFieldType.STRING.getDataType()),new RecordField("2",RecordFieldType.STRING.getDataType()))));
  DataType actual=DataTypeUtils.inferDataType(map,null);
  assertEquals(expected,actual);
}
