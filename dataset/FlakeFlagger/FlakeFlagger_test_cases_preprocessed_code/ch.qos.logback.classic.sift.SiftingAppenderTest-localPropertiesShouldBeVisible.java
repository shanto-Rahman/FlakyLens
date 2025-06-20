@Test public void localPropertiesShouldBeVisible() throws JoranException {
configure(SIFT_FOLDER_PREFIX + "propertyPropagation.xml");//RW
assertNotNull(listAppender);
assertEquals(1,listAppender.strList.size());
assertEquals(prefix + msg,strList.get(0));
}