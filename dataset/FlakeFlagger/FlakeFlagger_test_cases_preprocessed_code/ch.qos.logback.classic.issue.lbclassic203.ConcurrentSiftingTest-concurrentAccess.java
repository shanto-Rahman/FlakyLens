@Test public void concurrentAccess() throws JoranException, InterruptedException {
configure(FOLDER_PREFIX + "lbclassic203.xml");//RW
assertEquals(1,InstanceCountingAppender.INSTANCE_COUNT);
}