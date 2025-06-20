@Deployment(resources={"org/activiti/engine/test/api/runtime/multipleSubProcess.bpmn20.xml","org/activiti/engine/test/api/runtime/subProcess.bpmn20.xml"}) public void testOnlySubProcessExecutions() throws Exception {
assertEquals(2,executions.size());
if (execution.getParentId() == null) {
assertTrue(processInstance.getId() != execution.getProcessInstanceId());
if (execution.getParentId().equals(execution.getProcessInstanceId())) {
assertEquals("embeddedSubprocess",execution.getActivityId());
fail();
}
}
}