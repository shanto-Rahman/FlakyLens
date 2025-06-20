@Test public void testBuildStartKeyAndEndKey() throws Exception {
  Pair<byte[],byte[]> pair=builder.buildStartkeyAndEndkey(index,queryInfo);
  byte[] first=pair.getFirst();
  byte[] second=pair.getSecond();
  byte[] firstRet=Bytes.add(Bytes.toBytes("test"),FConstants.DATA_ROW_SEP_STORE);
  firstRet=Bytes.add(firstRet,Bytes.toBytes(11),FConstants.DATA_ROW_SEP_STORE);
  byte[] secondRet=Bytes.add(Bytes.toBytes("test"),FConstants.DATA_ROW_SEP_STORE);
  secondRet=Bytes.add(secondRet,Bytes.toBytes(11),FConstants.DATA_ROW_SEP_STORE);
  secondRet=Bytes.add(secondRet,Bytes.toBytes(199L));
  assertTrue(Bytes.equals(first,firstRet));
  assertTrue(Bytes.equals(second,secondRet));
}
