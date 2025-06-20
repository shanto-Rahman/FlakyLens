@Deployment(resources={"org/activiti/engine/test/db/processOne.bpmn20.xml"}) public void testProcessDefinitionActiveByDefault(){
assertFalse(processDefinition.isSuspended());
}