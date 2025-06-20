@Deployment(resources={"org/activiti/engine/test/api/event/TaskEventsTest.testEventFiring.bpmn20.xml"}) public void testEventFiringOrdering(){
assertEquals(ActivitiEventType.ENTITY_CREATED,event.getType());
assertTrue(event.getEntity() instanceof Task);
assertEquals(ActivitiEventType.ENTITY_INITIALIZED,event.getType());
assertTrue(event.getEntity() instanceof Task);
assertEquals(ActivitiEventType.TASK_CREATED,event.getType());
assertTrue(event.getEntity() instanceof Task);
assertEquals(task.getId(),taskFromEvent.getId());
assertEquals("The ScriptTaskListener must set this value before the dispatchEvent fires.","scriptedAssignee",taskFromEvent.getAssignee());
assertEquals("The ScriptTaskListener must set this value before the dispatchEvent fires.",877,taskFromEvent.getPriority());
}