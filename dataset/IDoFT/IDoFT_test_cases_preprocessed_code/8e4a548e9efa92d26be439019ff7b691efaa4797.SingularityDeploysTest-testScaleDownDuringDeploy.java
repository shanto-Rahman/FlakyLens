@Test public void testScaleDownDuringDeploy(){
Assertions.assertEquals(2,taskManager.getActiveTaskIdsForDeploy(requestId,secondDeployId).size());
Assertions.assertEquals(1,taskManager.getCleanupTaskIds().size());
Assertions.assertEquals(2,taskManager.getCleanupTaskIds().size());
Assertions.assertEquals(3,taskManager.getCleanupTaskIds().size());
}