@Test public void testJoinCollectionString() throws Exception {
assertEquals("",StringUtils.join(list,","));
assertEquals("v1",StringUtils.join(list,"-"));
assertEquals("v1:v2:v3",out);
}