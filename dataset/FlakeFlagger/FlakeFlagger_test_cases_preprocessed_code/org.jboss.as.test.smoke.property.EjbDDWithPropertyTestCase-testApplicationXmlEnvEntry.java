@Test public void testApplicationXmlEnvEntry() throws Exception {
assertEquals("foo" + System.getProperty("file.separator") + "bar",value);
}