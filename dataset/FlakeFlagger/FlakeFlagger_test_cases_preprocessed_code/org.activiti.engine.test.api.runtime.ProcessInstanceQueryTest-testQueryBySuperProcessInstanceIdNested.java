@Deployment(resources={"org/activiti/engine/test/api/runtime/superProcessWithNestedSubProcess.bpmn20.xml","org/activiti/engine/test/api/runtime/nestedSubProcess.bpmn20.xml","org/activiti/engine/test/api/runtime/subProcess.bpmn20.xml"}) public void testQueryBySuperProcessInstanceIdNested(){
assertNotNull(subProcessInstance);
assertNotNull(nestedSubProcessInstance);
}