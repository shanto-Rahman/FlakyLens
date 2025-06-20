@Test public void testIteratorForAppenders() throws Exception {
assertTrue("Bad Appender",app == ta || app == tab);
assertTrue("Incorrect number of appenders",size == 2);
}