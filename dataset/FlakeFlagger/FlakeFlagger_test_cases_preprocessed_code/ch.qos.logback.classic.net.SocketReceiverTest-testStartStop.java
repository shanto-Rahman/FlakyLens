@Test public void testStartStop() throws Exception {
assertTrue(receiver.isStarted());
receiver.awaitConnectorCreated(DELAY);//IT
assertFalse(receiver.isStarted());
}