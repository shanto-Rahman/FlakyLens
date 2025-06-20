@Deployment(resources={"org/activiti/engine/test/db/processOne.bpmn20.xml"}) public void testCannotSuspendActiveProcessDefinition(){
assertFalse(processDefinition.isSuspended());
fail("Exception expected");
}