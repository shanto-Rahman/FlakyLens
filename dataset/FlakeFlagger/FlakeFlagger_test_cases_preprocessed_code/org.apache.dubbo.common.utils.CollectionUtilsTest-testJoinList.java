@Test public void testJoinList() throws Exception {
assertEquals("",CollectionUtils.join(list,"/"));
assertEquals("x",CollectionUtils.join(list,"-"));
assertEquals("a/b",CollectionUtils.join(list,"/"));
}