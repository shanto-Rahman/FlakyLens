@Deployment(resources={"org/activiti/examples/bpmn/tasklistener/TaskListenerTest.bpmn20.xml"}) public void testTaskListenerWithExpression(){
assertEquals(null,runtimeService.getVariable(processInstance.getId(),"greeting2"));
assertEquals("Write meeting notes",runtimeService.getVariable(processInstance.getId(),"greeting2"));
}