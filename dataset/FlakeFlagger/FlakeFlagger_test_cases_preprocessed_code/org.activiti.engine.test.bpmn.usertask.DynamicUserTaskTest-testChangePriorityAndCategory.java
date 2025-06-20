@Deployment(resources={"org/activiti/engine/test/bpmn/usertask/DynamicUserTaskTest.assignment.bpmn20.xml"}) public void testChangePriorityAndCategory(){
assertEquals(50,task.getPriority());
assertNull(task.getCategory());
assertEquals(99,task.getPriority());
assertEquals("categoryTest",task.getCategory());
}