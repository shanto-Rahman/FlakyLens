@Deployment public void testOnCloseFailureExecutionListenersWithRollback(){
assertEquals(2,currentActivities.size());
assertEquals("serviceTask1",currentActivities.get(0).getActivityId());
assertEquals("Service Task 1",currentActivities.get(0).getActivityName());
assertEquals("serviceTask3",currentActivities.get(1).getActivityId());
assertEquals("Service Task 3",currentActivities.get(1).getActivityName());
}