@Test public void testDatanodeStateMachineWithIdWriteFail() throws Exception {
  File idPath=new File(conf.get(ScmConfigKeys.OZONE_SCM_DATANODE_ID_DIR),OzoneConsts.OZONE_SCM_DATANODE_ID_FILE_DEFAULT);
  idPath.delete();
  DatanodeDetails datanodeDetails=getNewDatanodeDetails();
  DatanodeDetails.Port port=DatanodeDetails.newPort(DatanodeDetails.Port.Name.STANDALONE,OzoneConfigKeys.DFS_CONTAINER_IPC_PORT_DEFAULT);
  datanodeDetails.setPort(port);
  try (DatanodeStateMachine stateMachine=new DatanodeStateMachine(datanodeDetails,conf,null,null,null)){
    DatanodeStateMachine.DatanodeStates currentState=stateMachine.getContext().getState();
    Assert.assertEquals(DatanodeStateMachine.DatanodeStates.INIT,currentState);
    DatanodeState<DatanodeStateMachine.DatanodeStates> task=stateMachine.getContext().getTask();
    Assert.assertEquals(InitDatanodeState.class,task.getClass());
    idPath.getParentFile().mkdirs();
    idPath.getParentFile().setReadOnly();
    task.execute(executorService);
    DatanodeStateMachine.DatanodeStates newState=task.await(2,TimeUnit.SECONDS);
    Assert.assertEquals(DatanodeStateMachine.DatanodeStates.SHUTDOWN,newState);
    idPath.getParentFile().setWritable(true);
  }
 }
