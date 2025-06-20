@Test public void testJoinAll() throws Exception {
assertNull(CollectionUtils.joinAll(null,null));
assertNull(CollectionUtils.joinAll(null,"-"));
if (entry.getValue() == null) continue;
assertEquals(expected,output);
}