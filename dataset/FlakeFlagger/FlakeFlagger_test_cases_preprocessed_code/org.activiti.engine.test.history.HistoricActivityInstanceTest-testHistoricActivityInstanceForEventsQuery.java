@Deployment public void testHistoricActivityInstanceForEventsQuery(){
assertEquals(1,taskService.createTaskQuery().count());
assertEquals(1,historyService.createHistoricActivityInstanceQuery().activityId("noop").list().size());
assertEquals(1,historyService.createHistoricActivityInstanceQuery().activityId("userTask").list().size());
assertEquals(1,historyService.createHistoricActivityInstanceQuery().activityId("intermediate-event").list().size());
assertEquals(1,historyService.createHistoricActivityInstanceQuery().activityId("start").list().size());
assertEquals(1,historyService.createHistoricActivityInstanceQuery().activityId("end").list().size());
assertNotNull(intermediateEvent.getStartTime());
assertNotNull(intermediateEvent.getEndTime());
assertNotNull(startEvent.getStartTime());
assertNotNull(startEvent.getEndTime());
assertNotNull(endEvent.getStartTime());
assertNotNull(endEvent.getEndTime());
}