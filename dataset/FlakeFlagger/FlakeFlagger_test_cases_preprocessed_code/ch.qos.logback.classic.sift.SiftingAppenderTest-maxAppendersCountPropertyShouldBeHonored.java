@Test public void maxAppendersCountPropertyShouldBeHonored() throws JoranException {
configure(SIFT_FOLDER_PREFIX + "maxAppenderCount.xml");//RW
assertEquals(max,tracker.allKeys().size());
assertNull(tracker.find("" + (diff + 0)));
assertNotNull(tracker.find("" + (diff + i)));
}