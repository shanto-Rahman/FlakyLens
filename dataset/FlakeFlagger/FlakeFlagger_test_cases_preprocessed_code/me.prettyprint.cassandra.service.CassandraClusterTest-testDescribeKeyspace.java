@Test public void testDescribeKeyspace() throws Exception {
assertNotNull(keyspaceDetail);
assertEquals(7,keyspaceDetail.getCfDefs().size());
}