@Test public void multipleNesting() throws JoranException {
configure(SIFT_FOLDER_PREFIX + "multipleNesting.xml");//RW
assertNotNull(listAppender);
}