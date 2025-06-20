@Test public void timeoutPropertyShouldBeHonored() throws JoranException, InterruptedException {
configure(SIFT_FOLDER_PREFIX + "timeout.xml");//RW
assertEquals(1,tracker.getComponentCount());
assertEquals(0,tracker.getComponentCount());
}