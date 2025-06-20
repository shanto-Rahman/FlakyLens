@Test public void testBasicTypes() throws Exception {
  String dataFile="target/basicTypes.dat";
  BasicTypes basicTypes=new BasicTypes();
  basicTypes.setB(new BerBoolean(true));
  basicTypes.setI(new BerInteger(789));
  basicTypes.setOctStr(new BerOctetString(new byte[]{1,2,3,4,5}));
  basicTypes.setUtf8Str(new BerUTF8String("Some UTF-8 String. こんにちは世界。"));
  Map<String,Object> expectedValues=new HashMap<String,Object>(){
{
      put("b",true);
      put("i",BigInteger.valueOf(789));
      put("octStr","0102030405");
      put("utf8Str","Some UTF-8 String. こんにちは世界。");
    }
  }
;
  RecordSchema expectedSchema=new SimpleRecordSchema(Arrays.asList(new RecordField("b",RecordFieldType.BOOLEAN.getDataType()),new RecordField("i",RecordFieldType.BIGINT.getDataType()),new RecordField("octStr",RecordFieldType.STRING.getDataType()),new RecordField("utf8Str",RecordFieldType.STRING.getDataType())));
  testReadRecord(dataFile,basicTypes,expectedValues,expectedSchema);
}
