@Test public void testUserSpecifiedMain() throws Exception {
assertEquals("demo.Application",launcher.getMainClass());
assertNull(System.getProperty("loader.main"));
}