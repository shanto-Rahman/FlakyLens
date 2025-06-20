@Deployment(resources={"org/activiti/engine/test/api/runtime/superProcessWithNestedSubProcess.bpmn20.xml","org/activiti/engine/test/api/runtime/nestedSubProcess.bpmn20.xml","org/activiti/engine/test/api/runtime/subProcess.bpmn20.xml"}) public void testQueryWithExcludeSubprocesses(){
assertEquals(6,instanceList.size());
if (processInstance.getId().equals(superProcessInstance.getId())) {
if (processInstance.getId().equals(subProcessInstance.getId())) {
if (processInstance.getId().equals(nestedSubProcessInstance.getId())) {
}
}
}
assertTrue(superProcessFound);
assertFalse(subProcessFound);
assertFalse(nestedSubProcessFound);
assertEquals(8,instanceList.size());
}