@Test public void load() throws Exception {
assertNotNull(source);
assertEquals("spam",source.getProperty("foo.bar"));
}