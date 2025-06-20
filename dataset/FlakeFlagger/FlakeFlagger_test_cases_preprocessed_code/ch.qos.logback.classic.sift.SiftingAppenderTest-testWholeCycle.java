@Test public void testWholeCycle() throws JoranException {
configure(SIFT_FOLDER_PREFIX + "completeCycle.xml");//RW
assertNotNull(listAppender);
assertEquals(1,listAppender.list.size());
assertEquals("smoke",eventList.get(0).getMessage());
assertFalse(listAppender.isStarted());
assertEquals(1,sa.getAppenderTracker().allKeys().size());
assertTrue(sa.getAppenderTracker().allKeys().contains("cycleDefault"));
}