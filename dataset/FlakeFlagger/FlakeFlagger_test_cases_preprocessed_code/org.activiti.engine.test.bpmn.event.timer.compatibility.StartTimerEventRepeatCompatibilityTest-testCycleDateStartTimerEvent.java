/** 
 * Timer repetition
 */
public void testCycleDateStartTimerEvent() throws Exception {
assertEquals(1,repositoryService.createProcessDefinitionQuery().count());
assertEquals(1,jobs.size());
assertEquals(true,Math.abs(dueDateCalendar.getTime().getTime() - jobs.get(0).getDuedate().getTime()) < 2000);
assertEquals(0,processInstances.size());
assertEquals(0,tasks.size());
assertEquals(1,jobs.size());
assertEquals(9,processInstances.size());
assertEquals(9,tasks.size());
assertEquals(1,jobs.size());
assertEquals(true,Math.abs(dueDateCalendar.getTime().getTime() - jobs.get(0).getDuedate().getTime()) < 2000);
fail("Because the maximum number of repeats is reached it will not be executed other jobs");
assertEquals(10,processInstances.size());
assertEquals(0,jobs.size());
assertEquals(10,tasks.size());
if (ActivitiEventType.TIMER_FIRED.equals(eventReceived.getType())) {
}
if (ActivitiEventType.ENTITY_CREATED.equals(eventReceived.getType())) {
}
if (ActivitiEventType.ENTITY_DELETED.equals(eventReceived.getType())) {
}
assertEquals(10,timerFiredCount);
assertEquals(20,eventCreatedCount);
assertEquals(20,eventDeletedCount);
assertEquals("Task A",task.getName());
assertEquals(1,tasks.size());
assertEquals(0,processInstances.size());
assertEquals(0,jobs.size());
assertEquals(0,jobs.size());
assertEquals(0,tasks.size());
}