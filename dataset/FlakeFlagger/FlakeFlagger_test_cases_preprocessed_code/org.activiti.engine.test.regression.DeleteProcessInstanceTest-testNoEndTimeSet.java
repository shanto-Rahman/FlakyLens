@Deployment public void testNoEndTimeSet(){
log.info("Starting an instance of \"Demo Partial Deletion\" with a Task Type of \"user\".");//RW
assertNotNull(instanceUser);
log.info("Process instance (of process model " + instanceUser.getProcessDefinitionId() + ") started with id: "+ instanceUser.getId()+ ".");//RW
assertFalse(executionUser.isEnded());
assertNotNull(taskUser);
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.ACTIVITY)) {
assertNotNull(hInstanceUser.getEndTime());
log.info("End time for the deleted instance of \"Demo Partial Deletion\" that was started with a Task Type of \"user\": " + hInstanceUser.getEndTime() + ".");//RW
log.info("Successfully deleted the instance of \"Demo Partial Deletion\" that was started with a Task Type of \"user\".");//RW
}
log.info("Starting an instance of \"Demo Partial Deletion\" with a Task Type of \"java\".");//RW
assertNotNull(instanceJava);
log.info("Process instance (of process model " + instanceJava.getProcessDefinitionId() + ") started with id: "+ instanceJava.getId()+ ".");//RW
assertFalse(executionJava.isEnded());
assertNotNull(jobJava);
fail("Expected exception");
fail("Expected exception");
fail("Expected exception");
assertEquals(0,managementService.createTimerJobQuery().processInstanceId(instanceJava.getId()).count());
assertNotNull(jobJava);
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.ACTIVITY)) {
assertNotNull(hInstanceJava.getEndTime());
}
}