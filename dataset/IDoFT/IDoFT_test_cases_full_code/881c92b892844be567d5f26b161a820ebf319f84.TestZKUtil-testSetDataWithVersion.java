@Test public void testSetDataWithVersion() throws Exception {
  ZKUtil.createWithParents(ZKW,"/s1/s2/s3");
  int v0=getZNodeDataVersion("/s1/s2/s3");
  assertEquals(0,v0);
  ZKUtil.setData(ZKW,"/s1/s2/s3",Bytes.toBytes(12L));
  int v1=getZNodeDataVersion("/s1/s2/s3");
  assertEquals(1,v1);
  ZKUtil.multiOrSequential(ZKW,ImmutableList.of(ZKUtilOp.setData("/s1/s2/s3",Bytes.toBytes(13L),v1)),false);
  int v2=getZNodeDataVersion("/s1/s2/s3");
  assertEquals(2,v2);
}
