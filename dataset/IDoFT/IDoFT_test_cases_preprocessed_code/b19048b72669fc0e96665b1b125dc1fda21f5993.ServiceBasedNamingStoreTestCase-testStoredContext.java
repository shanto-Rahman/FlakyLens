@Test public void testStoredContext() throws Exception {
if ("blah/blah2".equals(name.toString())) {
}
if (!"hi/there".equals(name.toString())) throw new IllegalArgumentException("Expected hi/there");
assertNotNull(obj);
assertEquals(new Integer(5),obj);
}