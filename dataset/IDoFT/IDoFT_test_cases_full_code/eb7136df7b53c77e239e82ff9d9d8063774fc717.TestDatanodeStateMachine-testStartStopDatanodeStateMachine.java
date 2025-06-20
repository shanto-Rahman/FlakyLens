/** 
 * Assert that starting statemachine executes the Init State.
 */
@Test public void testStartStopDatanodeStateMachine() throws IOException, InterruptedException, TimeoutException {
  try (DatanodeStateMachine stateMachine=new DatanodeStateMachine(getNewDatanodeDetails(),conf,null,null,null)){
    stateMachine.startDaemon();
    SCMConnectionManager connectionManager=stateMachine.getConnectionManager();
    GenericTestUtils.waitFor(() -> {
      int size=connectionManager.getValues().size();
      LOG.info("connectionManager.getValues().size() is {}",size);
      return size == 1;
    }
,1000,30000);
    stateMachine.stopDaemon();
    assertTrue(stateMachine.isDaemonStopped());
  }
 }
