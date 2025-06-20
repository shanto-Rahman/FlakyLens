@Test public void testStartStop() throws Exception {
assertTrue(runner.isContextInjected());
assertTrue(runner.isRunning());
assertSame(listener,receiver.getLastListener());
assertFalse(runner.isRunning());
}