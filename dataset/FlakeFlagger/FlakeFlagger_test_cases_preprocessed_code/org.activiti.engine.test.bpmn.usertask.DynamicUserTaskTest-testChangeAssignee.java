@Deployment(resources={"org/activiti/engine/test/bpmn/usertask/DynamicUserTaskTest.assignment.bpmn20.xml"}) public void testChangeAssignee(){
assertEquals("test",task.getAssignee());
assertEquals("test2",task.getAssignee());
}