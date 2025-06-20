@Test public void testRead() throws Exception {
  assertArrayEquals(DATA,RO_ZK.get(PATH).get());
  assertEquals(CHILDREN,RO_ZK.exists(PATH).get().getNumChildren());
  List<String> children=RO_ZK.list(PATH).get();
  assertEquals(CHILDREN,children.size());
  Collections.sort(children);
  for (int i=0; i < CHILDREN; i++) {
    assertEquals("c" + i,children.get(i));
  }
  assertNotNull(RO_ZK.zookeeper);
  waitForIdleConnectionClosed();
}
