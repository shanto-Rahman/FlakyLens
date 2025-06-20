@Test public void testSetDataWithVersion() throws Exception {
ZKUtil.createWithParents(ZKW,"/s1/s2/s3");//RW
assertEquals(0,v0);
ZKUtil.setData(ZKW,"/s1/s2/s3",Bytes.toBytes(12L));//RW
assertEquals(1,v1);
ZKUtil.multiOrSequential(ZKW,ImmutableList.of(ZKUtilOp.setData("/s1/s2/s3",Bytes.toBytes(13L),v1)),false);//RW
assertEquals(2,v2);
}