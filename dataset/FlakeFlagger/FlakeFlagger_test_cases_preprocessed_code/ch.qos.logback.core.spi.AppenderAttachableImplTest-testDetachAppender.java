@Test public void testDetachAppender() throws Exception {
assertTrue("Appender not detached",aai.detachAppender(tab));
assertNull("Appender was not removed",aai.getAppender("test"));
assertFalse("Appender detach error",aai.detachAppender(tab));
}