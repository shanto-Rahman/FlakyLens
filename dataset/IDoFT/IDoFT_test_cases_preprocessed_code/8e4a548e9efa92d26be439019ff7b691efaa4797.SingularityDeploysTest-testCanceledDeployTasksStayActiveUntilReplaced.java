@Test public void testCanceledDeployTasksStayActiveUntilReplaced(){
Assertions.assertEquals(1,taskManager.getPendingTaskIds().size());
Assertions.assertEquals(1,taskManager.getActiveTaskIdsForDeploy(requestId,secondDeployId).size());
Assertions.assertEquals(1,taskManager.getCleanupTaskIds().size());
Assertions.assertTrue(taskManager.getCleanupTaskIds().contains(firstTask.getTaskId()));
Assertions.assertEquals(2,deployProgressStepOne.getTargetActiveInstances());
Assertions.assertEquals(1,pendingTaskIds.size());
Assertions.assertEquals(firstDeployId,pendingTaskIds.get(0).getDeployId());
Assertions.assertEquals(1,cleanupTaskIds.size());
Assertions.assertEquals(secondDeployId,cleanupTaskIds.get(0).getDeployId());
Assertions.assertEquals(0,taskManager.getCleanupTaskIds().size());
Assertions.assertEquals(2,taskManager.getActiveTaskIdsForDeploy(requestId,firstDeployId).size());
}