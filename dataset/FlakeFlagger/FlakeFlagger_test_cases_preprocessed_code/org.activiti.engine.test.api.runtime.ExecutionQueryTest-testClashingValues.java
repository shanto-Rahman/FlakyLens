@Deployment(resources={"org/activiti/engine/test/api/oneTaskProcess.bpmn20.xml"}) public void testClashingValues() throws Exception {
assertEquals(1,executions.size());
assertEquals(processInstance.getId(),executions.get(0).getId());
}