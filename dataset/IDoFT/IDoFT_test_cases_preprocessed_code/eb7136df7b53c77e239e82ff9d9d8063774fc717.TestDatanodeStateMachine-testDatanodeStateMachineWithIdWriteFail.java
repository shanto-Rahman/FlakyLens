@Test public void testDatanodeStateMachineWithIdWriteFail() throws Exception {
File idPath=new File(conf.get(ScmConfigKeys.OZONE_SCM_DATANODE_ID_DIR),OzoneConsts.OZONE_SCM_DATANODE_ID_FILE_DEFAULT);
Assert.assertEquals(DatanodeStateMachine.DatanodeStates.INIT,currentState);
Assert.assertEquals(InitDatanodeState.class,task.getClass());
Assert.assertEquals(DatanodeStateMachine.DatanodeStates.SHUTDOWN,newState);
}