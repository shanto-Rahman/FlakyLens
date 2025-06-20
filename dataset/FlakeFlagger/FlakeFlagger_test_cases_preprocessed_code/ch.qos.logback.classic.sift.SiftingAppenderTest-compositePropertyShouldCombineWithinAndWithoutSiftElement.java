@Test public void compositePropertyShouldCombineWithinAndWithoutSiftElement() throws JoranException {
configure(SIFT_FOLDER_PREFIX + "compositeProperty.xml");//RW
assertNotNull(listAppender);
assertEquals(1,listAppender.strList.size());
assertEquals(prefix + msg,strList.get(0));
}