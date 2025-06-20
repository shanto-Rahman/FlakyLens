@Test public void testBuildIndexKeys(){
  Pair<byte[],String> indexKeys=builder.buildIndexKey(index,values,PK);
  byte[] first=Bytes.add(Bytes.toBytes("test"),FConstants.DATA_ROW_SEP_STORE);
  first=Bytes.add(first,Bytes.toBytes(199),FConstants.DATA_ROW_SEP_STORE);
  first=Bytes.add(first,Bytes.toBytes(11),FConstants.DATA_ROW_SEP_STORE);
  first=Bytes.add(first,PK);
  byte[] second=Bytes.add(Bytes.toBytes("test"),FConstants.DATA_ROW_SEP_STORE);
  second=Bytes.add(second,Bytes.toBytes(11),FConstants.DATA_ROW_SEP_STORE);
  second=Bytes.add(second,Bytes.toBytes(199),FConstants.DATA_ROW_SEP_STORE);
  second=Bytes.add(second,PK);
  assertTrue(Bytes.equals(indexKeys.getFirst(),first) || Bytes.equals(indexKeys.getFirst(),second));
  assertTrue(indexs.contains(indexKeys.getSecond()));
}
