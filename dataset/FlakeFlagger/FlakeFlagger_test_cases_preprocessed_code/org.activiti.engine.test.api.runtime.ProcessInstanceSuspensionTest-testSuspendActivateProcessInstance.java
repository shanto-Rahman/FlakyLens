@Deployment(resources={"org/activiti/engine/test/api/runtime/oneTaskProcess.bpmn20.xml"}) public void testSuspendActivateProcessInstance(){
assertFalse(processInstance.isSuspended());
assertTrue(processInstance.isSuspended());
assertFalse(processInstance.isSuspended());
}