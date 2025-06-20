@Deployment(resources={"org/activiti/engine/test/bpmn/usertask/DynamicUserTaskTest.basictask.bpmn20.xml"}) public void testChangeNameAndDescription(){
assertNull(task.getName());
assertNull(task.getDescription());
assertEquals("Task name test",task.getName());
assertEquals("Task description test",task.getDescription());
}