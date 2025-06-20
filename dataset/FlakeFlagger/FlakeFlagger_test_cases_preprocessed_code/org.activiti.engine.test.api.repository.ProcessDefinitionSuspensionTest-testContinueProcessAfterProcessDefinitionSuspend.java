@Deployment(resources={"org/activiti/engine/test/api/runtime/oneTaskProcess.bpmn20.xml"}) public void testContinueProcessAfterProcessDefinitionSuspend(){
assertNotNull(task);
assertEquals(1,runtimeService.createProcessInstanceQuery().count());
assertEquals(0,runtimeService.createProcessInstanceQuery().count());
}