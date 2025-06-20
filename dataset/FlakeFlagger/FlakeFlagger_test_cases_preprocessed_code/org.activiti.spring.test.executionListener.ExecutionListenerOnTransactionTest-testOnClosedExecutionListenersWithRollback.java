@Deployment public void testOnClosedExecutionListenersWithRollback(){
assertEquals(1,currentActivities.size());
assertEquals("serviceTask1",currentActivities.get(0).getActivityId());
assertEquals("Service Task 1",currentActivities.get(0).getActivityName());
assertEquals(processInstance.getId(),currentActivities.get(0).getProcessInstanceId());
assertNotNull(currentActivities.get(0).getProcessInstanceId());
assertEquals(1,managementService.createTimerJobQuery().processInstanceId(processInstance.getId()).count());
assertEquals(1,activeActivityIds.size());
assertEquals("serviceTask2",activeActivityIds.get(0));
}