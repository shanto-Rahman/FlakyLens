@Test public void testStartStop() throws Exception {
assertTrue(runner.isContextInjected());
assertTrue(runner.isRunning());
assertSame(listener,appender.getLastListener());
assertFalse(runner.isRunning());
}