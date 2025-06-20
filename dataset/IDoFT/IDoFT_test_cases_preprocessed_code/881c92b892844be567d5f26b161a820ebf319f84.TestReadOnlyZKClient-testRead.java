@Test public void testRead() throws Exception {
assertArrayEquals(DATA,RO_ZK.get(PATH).get());//RW
assertEquals(CHILDREN,RO_ZK.exists(PATH).get().getNumChildren());//RW
List<String> children=RO_ZK.list(PATH).get();//RW
assertEquals(CHILDREN,children.size());//RW
for (int i=0; i < CHILDREN; i++) //RW
assertEquals("c" + i,children.get(i));
assertNotNull(RO_ZK.zookeeper);//RW
}