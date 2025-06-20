@Test public void testTyrusBroadcaster() throws DeploymentException {
if (ea1.peer == null) {
}
if (ea2.peer == null) {
}
assertTrue("Timeout reached. Message latch value: " + messageLatch.getCount(),messageLatch.await(5,TimeUnit.SECONDS));
}