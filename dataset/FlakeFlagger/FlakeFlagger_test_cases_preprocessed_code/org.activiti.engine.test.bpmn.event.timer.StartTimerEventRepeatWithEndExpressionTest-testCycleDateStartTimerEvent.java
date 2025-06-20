/** 
 * Timer repetition
 */
public void testCycleDateStartTimerEvent() throws Exception {
assertEquals(1,repositoryService.createProcessDefinitionQuery().count());
assertEquals(1,jobs.size());
assertEquals(true,Math.abs(dueDateCalendar.getTime().getTime() - jobs.get(0).getDuedate().getTime()) < 2000);
assertEquals(0,processInstances.size());
assertEquals(0,tasks.size());
assertEquals(1,managementService.createTimerJobQuery().count());
assertEquals(1,processInstances.size());
assertEquals(1,tasks.size());
assertEquals(1,jobs.size());
assertEquals(true,Math.abs(dueDateCalendar.getTime().getTime() - jobs.get(0).getDuedate().getTime()) < 2000);
assertEquals(2,processInstances.size());
assertEquals(0,jobs.size());
assertEquals(0,jobs.size());
assertEquals(2,tasks.size());
if (ActivitiEventType.TIMER_FIRED.equals(eventReceived.getType())) {
}
if (ActivitiEventType.ENTITY_CREATED.equals(eventReceived.getType())) {
}
if (ActivitiEventType.ENTITY_DELETED.equals(eventReceived.getType())) {
}
assertEquals(2,timerFiredCount);
assertEquals(4,eventCreatedCount);
assertEquals(4,eventDeletedCount);
assertEquals("Task A",task.getName());
assertEquals(1,tasks.size());
assertEquals(0,processInstances.size());
assertEquals(0,jobs.size());
assertEquals(0,jobs.size());
assertEquals(0,tasks.size());
}