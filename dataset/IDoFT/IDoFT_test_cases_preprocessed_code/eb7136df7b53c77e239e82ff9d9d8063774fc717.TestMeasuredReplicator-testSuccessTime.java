@Test public void testSuccessTime() throws Exception {
Assert.assertTrue("Measured time should be at least 300 ms but was " + measuredReplicator.getSuccessTime().value(),measuredReplicator.getSuccessTime().value() >= 300L);
}