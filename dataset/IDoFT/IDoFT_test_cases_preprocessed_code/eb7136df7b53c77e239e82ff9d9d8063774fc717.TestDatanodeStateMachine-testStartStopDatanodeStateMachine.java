/** 
 * Assert that starting statemachine executes the Init State.
 */
@Test public void testStartStopDatanodeStateMachine() throws IOException, InterruptedException, TimeoutException {
assertTrue(stateMachine.isDaemonStopped());
}