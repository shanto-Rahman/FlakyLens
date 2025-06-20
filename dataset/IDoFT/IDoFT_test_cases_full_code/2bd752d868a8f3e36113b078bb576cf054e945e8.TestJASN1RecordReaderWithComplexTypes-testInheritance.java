@Test public void testInheritance() throws Exception {
  String dataFile="target/inheriting_integer_and_string_wrapper.dat";
  InheritingIntegerAndStringWrapper berValue=new InheritingIntegerAndStringWrapper();
  berValue.setI(new BerInteger(53286));
  berValue.setStr(new BerUTF8String("Some UTF-8 String. こんにちは世界。"));
  RecordSchema expectedSchema=new SimpleRecordSchema(Arrays.asList(new RecordField("i",RecordFieldType.BIGINT.getDataType()),new RecordField("str",RecordFieldType.STRING.getDataType())));
  Map<String,Object> expectedValues=new HashMap<String,Object>(){
{
      put("i",BigInteger.valueOf(53286L));
      put("str","Some UTF-8 String. こんにちは世界。");
    }
  }
;
  testReadRecord(dataFile,berValue,expectedValues,expectedSchema);
}
