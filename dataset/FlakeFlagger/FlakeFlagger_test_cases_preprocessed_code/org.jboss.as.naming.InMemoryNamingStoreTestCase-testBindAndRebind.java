@Test public void testBindAndRebind() throws Exception {
assertEquals(object,nameStore.lookup(name));
assertEquals(objectTwo,nameStore.lookup(name));
}