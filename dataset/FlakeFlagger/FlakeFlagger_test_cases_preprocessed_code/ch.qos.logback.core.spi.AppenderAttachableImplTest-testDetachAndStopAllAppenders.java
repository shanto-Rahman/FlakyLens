@Test public void testDetachAndStopAllAppenders() throws Exception {
assertTrue("Appender was not started",tab.isStarted());
assertNull("Appender was not removed",aai.getAppender("test"));
assertFalse("Appender was not stopped",tab.isStarted());
}