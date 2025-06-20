@Test public void testAutoRemove() throws Exception {
assertNotNull(nameStore.lookup(new CompositeName("test/item")));
assertNotNull(nameStore.lookup(new CompositeName("test")));
fail("Should have throw name not found exception");
}