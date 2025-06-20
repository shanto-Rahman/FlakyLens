@Deployment(resources={"org/activiti/engine/test/api/oneTaskProcess.bpmn20.xml"}) public void testQueryStartedBy() throws Exception {
assertEquals(1,executions.size());
}