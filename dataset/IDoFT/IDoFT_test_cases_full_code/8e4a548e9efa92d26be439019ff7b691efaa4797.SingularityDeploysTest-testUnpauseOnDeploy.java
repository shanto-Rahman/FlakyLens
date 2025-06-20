@Test public void testUnpauseOnDeploy(){
  initRequest();
  initFirstDeploy();
  requestManager.pause(request,System.currentTimeMillis(),Optional.<String>empty(),Optional.<String>empty());
  boolean exception=false;
  try {
    deploy("d2");
  }
 catch (  Exception e) {
    exception=true;
  }
  Assertions.assertTrue(exception);
  deploy("d3",Optional.of(true));
  Assertions.assertTrue(requestManager.getRequest(requestId).get().getState() == RequestState.DEPLOYING_TO_UNPAUSE);
  scheduler.drainPendingQueue();
  sms.resourceOffers(Arrays.asList(createOffer(20,20000,50000,"agent1","host1"))).join();
  statusUpdate(taskManager.getActiveTasks().get(0),TaskState.TASK_FAILED);
  deployChecker.checkDeploys();
  Assertions.assertTrue(requestManager.getRequest(requestId).get().getState() == RequestState.PAUSED);
  Assertions.assertTrue(taskManager.getActiveTaskIds().isEmpty());
  Assertions.assertTrue(taskManager.getPendingTaskIds().isEmpty());
  Assertions.assertTrue(requestManager.getPendingRequests().isEmpty());
  deploy("d4",Optional.of(true));
  Assertions.assertTrue(requestManager.getRequest(requestId).get().getState() == RequestState.DEPLOYING_TO_UNPAUSE);
  scheduler.drainPendingQueue();
  sms.resourceOffers(Arrays.asList(createOffer(20,20000,50000,"agent1","host1"))).join();
  statusUpdate(taskManager.getActiveTasks().get(0),TaskState.TASK_RUNNING);
  deployChecker.checkDeploys();
  deployChecker.checkDeploys();
  RequestState requestState=requestManager.getRequest(requestId).get().getState();
  Assertions.assertTrue(requestState == RequestState.ACTIVE);
}
