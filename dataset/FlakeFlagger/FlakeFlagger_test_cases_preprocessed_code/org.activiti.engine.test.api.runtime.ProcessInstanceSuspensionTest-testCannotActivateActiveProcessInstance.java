@Deployment(resources={"org/activiti/engine/test/api/runtime/oneTaskProcess.bpmn20.xml"}) public void testCannotActivateActiveProcessInstance(){
assertFalse(processInstance.isSuspended());
fail("Expected activiti exception");
}