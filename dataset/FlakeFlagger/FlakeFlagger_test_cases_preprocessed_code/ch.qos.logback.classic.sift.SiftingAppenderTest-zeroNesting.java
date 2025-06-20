@Test public void zeroNesting() throws JoranException {
configure(SIFT_FOLDER_PREFIX + "zeroNesting.xml");//RW
assertNotNull(appender);
}