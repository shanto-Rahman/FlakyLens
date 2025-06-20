@Test public void testDetachAppenderByName() throws Exception {
assertTrue(aai.detachAppender("test"));
assertTrue(aai.detachAppender("test1"));
assertFalse(aai.detachAppender("test1"));
}