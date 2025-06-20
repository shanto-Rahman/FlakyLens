@Deployment(resources={"org/activiti/examples/bpmn/tasklistener/TaskListenerTest.bpmn20.xml"}) public void testTaskCompleteListener(){
assertEquals(null,runtimeService.getVariable(processInstance.getId(),"greeting"));
assertEquals(null,runtimeService.getVariable(processInstance.getId(),"expressionValue"));
assertEquals("Hello from The Process",runtimeService.getVariable(processInstance.getId(),"greeting"));
assertEquals("Act",runtimeService.getVariable(processInstance.getId(),"shortName"));
}