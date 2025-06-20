@Test public void sessionFinalizationShouldCauseLingering() throws JoranException {
configure(SIFT_FOLDER_PREFIX + "lingering.xml");//RW
assertEquals(1,tracker.allKeys().size());
assertTrue(appender.isStarted());
assertFalse(appender.isStarted());
assertEquals(0,tracker.allKeys().size());
}