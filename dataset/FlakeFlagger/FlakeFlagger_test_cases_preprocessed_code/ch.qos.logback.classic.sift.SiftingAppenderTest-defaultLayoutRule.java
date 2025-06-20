@Test public void defaultLayoutRule() throws JoranException {
configure(SIFT_FOLDER_PREFIX + "defaultLayoutRule.xml");//RW
assertNotNull(listAppender);
assertEquals(1,strList.size());
assertEquals("DEBUG hello",strList.get(0));
}