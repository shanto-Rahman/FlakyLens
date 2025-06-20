@Deployment(resources={"org/activiti/engine/test/api/runtime/oneTaskProcess.bpmn20.xml"}) public void testProcessInstanceActiveByDefault(){
assertFalse(processInstance.isSuspended());
}