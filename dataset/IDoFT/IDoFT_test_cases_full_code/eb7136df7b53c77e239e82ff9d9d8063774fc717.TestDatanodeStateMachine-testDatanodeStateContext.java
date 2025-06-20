/** 
 * This test explores the state machine by invoking each call in sequence just like as if the state machine would call it. Because this is a test we are able to verify each of the assumptions. <p> Here is what happens at High level. <p> 1. We start the datanodeStateMachine in the INIT State. <p> 2. We invoke the INIT state task. <p> 3. That creates a set of RPC endpoints that are ready to connect to SCMs. <p> 4. We assert that we have moved to the running state for the DatanodeStateMachine. <p> 5. We get the task for the Running State - Executing that running state, makes the first network call in of the state machine. The Endpoint is in the GETVERSION State and we invoke the task. <p> 6. We assert that this call was a success by checking that each of the endponts now have version response that it got from the SCM server that it was talking to and also each of the mock server serviced one RPC call. <p> 7. Since the Register is done now, next calls to get task will return HeartbeatTask, which sends heartbeats to SCM. We assert that we get right task from sub-system below.
 * @throws IOException
 */
@Test public void testDatanodeStateContext() throws IOException, InterruptedException, ExecutionException, TimeoutException {
  File idPath=new File(conf.get(ScmConfigKeys.OZONE_SCM_DATANODE_ID_DIR),OzoneConsts.OZONE_SCM_DATANODE_ID_FILE_DEFAULT);
  idPath.delete();
  DatanodeDetails datanodeDetails=getNewDatanodeDetails();
  DatanodeDetails.Port port=DatanodeDetails.newPort(DatanodeDetails.Port.Name.STANDALONE,OzoneConfigKeys.DFS_CONTAINER_IPC_PORT_DEFAULT);
  datanodeDetails.setPort(port);
  ContainerUtils.writeDatanodeDetailsTo(datanodeDetails,idPath);
  try (DatanodeStateMachine stateMachine=new DatanodeStateMachine(datanodeDetails,conf,null,null,null)){
    DatanodeStateMachine.DatanodeStates currentState=stateMachine.getContext().getState();
    Assert.assertEquals(DatanodeStateMachine.DatanodeStates.INIT,currentState);
    DatanodeState<DatanodeStateMachine.DatanodeStates> task=stateMachine.getContext().getTask();
    Assert.assertEquals(InitDatanodeState.class,task.getClass());
    task.execute(executorService);
    DatanodeStateMachine.DatanodeStates newState=task.await(2,TimeUnit.SECONDS);
    for (    EndpointStateMachine endpoint : stateMachine.getConnectionManager().getValues()) {
      Assert.assertEquals(EndpointStateMachine.EndPointStates.GETVERSION,endpoint.getState());
    }
    Assert.assertEquals(DatanodeStateMachine.DatanodeStates.RUNNING,newState);
    stateMachine.getContext().setState(newState);
    task=stateMachine.getContext().getTask();
    Assert.assertEquals(RunningDatanodeState.class,task.getClass());
    task.execute(executorService);
    newState=task.await(10,TimeUnit.SECONDS);
    GenericTestUtils.waitFor(() -> {
      for (      EndpointStateMachine endpoint : stateMachine.getConnectionManager().getValues()) {
        if (endpoint.getState() != EndpointStateMachine.EndPointStates.REGISTER) {
          return false;
        }
      }
      return true;
    }
,1000,50000);
    Assert.assertEquals(DatanodeStateMachine.DatanodeStates.RUNNING,newState);
    for (    EndpointStateMachine endpoint : stateMachine.getConnectionManager().getValues()) {
      Assert.assertEquals(EndpointStateMachine.EndPointStates.REGISTER,endpoint.getState());
      Assert.assertNotNull(endpoint.getVersion());
    }
    for (    ScmTestMock mock : mockServers) {
      Assert.assertEquals(1,mock.getRpcCount());
    }
    task=stateMachine.getContext().getTask();
    task.execute(executorService);
    newState=task.await(2,TimeUnit.SECONDS);
    Assert.assertEquals(DatanodeStateMachine.DatanodeStates.RUNNING,newState);
    for (    ScmTestMock mock : mockServers) {
      Assert.assertEquals(2,mock.getRpcCount());
    }
    task=stateMachine.getContext().getTask();
    task.execute(executorService);
    newState=task.await(2,TimeUnit.SECONDS);
    Assert.assertEquals(DatanodeStateMachine.DatanodeStates.RUNNING,newState);
    for (    ScmTestMock mock : mockServers) {
      Assert.assertEquals(1,mock.getHeartbeatCount());
    }
  }
 }
