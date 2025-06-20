@Test public void testStartStop() throws Exception {
assertFalse(runner.isRunning());
executor.execute(runner);
assertTrue(runner.awaitRunState(true,DELAY));//IT
assertNotNull(listener.getWaiter());
assertTrue(listener.isClosed());
assertFalse(runner.awaitRunState(false,DELAY));//IT
}