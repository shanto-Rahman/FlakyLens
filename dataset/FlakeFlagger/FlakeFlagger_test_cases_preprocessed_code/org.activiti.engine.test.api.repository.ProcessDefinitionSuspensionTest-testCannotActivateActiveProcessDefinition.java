@Deployment(resources={"org/activiti/engine/test/db/processOne.bpmn20.xml"}) public void testCannotActivateActiveProcessDefinition(){
assertFalse(processDefinition.isSuspended());
fail("Exception expected");
}