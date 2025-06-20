@Test public void propertyDefinedWithinSiftElementShouldBeVisible() throws JoranException {
configure(SIFT_FOLDER_PREFIX + "propertyDefinedInSiftElement.xml");//RW
assertNotNull(listAppender);
assertEquals(1,listAppender.strList.size());
assertEquals(prefix + msg,strList.get(0));
}