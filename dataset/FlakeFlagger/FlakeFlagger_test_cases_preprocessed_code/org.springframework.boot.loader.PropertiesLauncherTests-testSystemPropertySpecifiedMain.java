@Test public void testSystemPropertySpecifiedMain() throws Exception {
assertEquals("foo.Bar",launcher.getMainClass());
}