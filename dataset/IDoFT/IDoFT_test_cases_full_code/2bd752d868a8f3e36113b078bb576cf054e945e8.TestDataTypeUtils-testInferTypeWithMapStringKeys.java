@Test public void testInferTypeWithMapStringKeys(){
  Map<String,String> map=new HashMap<>();
  map.put("a","Hello");
  map.put("b","World");
  RecordDataType expected=(RecordDataType)RecordFieldType.RECORD.getRecordDataType(new SimpleRecordSchema(Arrays.asList(new RecordField("a",RecordFieldType.STRING.getDataType()),new RecordField("b",RecordFieldType.STRING.getDataType()))));
  DataType actual=DataTypeUtils.inferDataType(map,null);
  assertEquals(expected,actual);
}
