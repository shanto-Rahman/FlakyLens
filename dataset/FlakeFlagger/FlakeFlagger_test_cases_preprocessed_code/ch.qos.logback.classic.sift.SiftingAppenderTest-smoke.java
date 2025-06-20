@Test public void smoke() throws JoranException {
configure(SIFT_FOLDER_PREFIX + "smoke.xml");//RW
assertNotNull(appender);
assertEquals(1,listAppender.list.size());
assertEquals("smoke",eventList.get(0).getMessage());
}