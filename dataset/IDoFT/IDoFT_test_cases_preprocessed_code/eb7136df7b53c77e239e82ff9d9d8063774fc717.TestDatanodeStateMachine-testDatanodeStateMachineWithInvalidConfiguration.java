/** 
 * Test state transition with a list of invalid scm configurations, and verify the state transits to SHUTDOWN each time.
 */
@Test public void testDatanodeStateMachineWithInvalidConfiguration() throws Exception {
Assert.assertEquals(DatanodeStateMachine.DatanodeStates.INIT,currentState);
Assert.assertEquals(DatanodeStateMachine.DatanodeStates.SHUTDOWN,newState);
Assert.fail("Unexpected exception found");
}