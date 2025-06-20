/** 
 * Test state transition with a list of invalid scm configurations, and verify the state transits to SHUTDOWN each time.
 */
@Test public void testDatanodeStateMachineWithInvalidConfiguration() throws Exception {
  List<Map.Entry<String,String>> confList=new ArrayList<>();
  confList.add(Maps.immutableEntry(ScmConfigKeys.OZONE_SCM_NAMES,""));
  confList.add(Maps.immutableEntry(ScmConfigKeys.OZONE_SCM_NAMES,""));
  confList.add(Maps.immutableEntry(ScmConfigKeys.OZONE_SCM_NAMES,"x..y"));
  confList.add(Maps.immutableEntry(ScmConfigKeys.OZONE_SCM_NAMES,"scm:xyz"));
  confList.add(Maps.immutableEntry(ScmConfigKeys.OZONE_SCM_NAMES,"scm:123456"));
  confList.add(Maps.immutableEntry(ScmConfigKeys.OZONE_SCM_DATANODE_ID_DIR,""));
  confList.forEach((entry) -> {
    OzoneConfiguration perTestConf=new OzoneConfiguration(conf);
    perTestConf.setStrings(entry.getKey(),entry.getValue());
    LOG.info("Test with {} = {}",entry.getKey(),entry.getValue());
    try (DatanodeStateMachine stateMachine=new DatanodeStateMachine(getNewDatanodeDetails(),perTestConf,null,null,null)){
      DatanodeStateMachine.DatanodeStates currentState=stateMachine.getContext().getState();
      Assert.assertEquals(DatanodeStateMachine.DatanodeStates.INIT,currentState);
      DatanodeState<DatanodeStateMachine.DatanodeStates> task=stateMachine.getContext().getTask();
      task.execute(executorService);
      DatanodeStateMachine.DatanodeStates newState=task.await(2,TimeUnit.SECONDS);
      Assert.assertEquals(DatanodeStateMachine.DatanodeStates.SHUTDOWN,newState);
    }
 catch (    Exception e) {
      Assert.fail("Unexpected exception found");
    }
  }
);
}
