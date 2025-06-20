@Test public void testUnpauseOnDeploy(){
Assertions.assertTrue(exception);
Assertions.assertTrue(requestManager.getRequest(requestId).get().getState() == RequestState.DEPLOYING_TO_UNPAUSE);
Assertions.assertTrue(requestManager.getRequest(requestId).get().getState() == RequestState.PAUSED);
Assertions.assertTrue(taskManager.getActiveTaskIds().isEmpty());
Assertions.assertTrue(taskManager.getPendingTaskIds().isEmpty());
Assertions.assertTrue(requestManager.getPendingRequests().isEmpty());
Assertions.assertTrue(requestManager.getRequest(requestId).get().getState() == RequestState.DEPLOYING_TO_UNPAUSE);
Assertions.assertTrue(requestState == RequestState.ACTIVE);
}