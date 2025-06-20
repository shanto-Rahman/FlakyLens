@Test public void testSplitAll() throws Exception {
assertNull(CollectionUtils.splitAll(null,null));
assertNull(CollectionUtils.splitAll(null,"-"));
assertTrue(CollectionUtils.splitAll(new HashMap<String,List<String>>(),"-").isEmpty());
assertEquals(expected,CollectionUtils.splitAll(input,":"));
}