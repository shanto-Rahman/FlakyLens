@Test public void testIncrementalDeployCancel(){
Assertions.assertEquals(taskManager.getCleanupTasks().get(0).getCleanupType(),TaskCleanupType.INCREMENTAL_DEPLOY_CANCELLED);
Assertions.assertTrue(taskManager.getKilledTaskIdRecords().isEmpty());
Assertions.assertEquals(taskManager.getCleanupTasks().get(0).getCleanupType(),TaskCleanupType.INCREMENTAL_DEPLOY_CANCELLED);
Assertions.assertFalse(taskManager.getKilledTaskIdRecords().isEmpty());
}