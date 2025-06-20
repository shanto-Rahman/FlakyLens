@Deployment(resources={"org/activiti/engine/test/db/processOne.bpmn20.xml"}) public void testSuspendActivateProcessDefinitionById(){
assertFalse(processDefinition.isSuspended());
assertTrue(processDefinition.isSuspended());
assertFalse(processDefinition.isSuspended());
}