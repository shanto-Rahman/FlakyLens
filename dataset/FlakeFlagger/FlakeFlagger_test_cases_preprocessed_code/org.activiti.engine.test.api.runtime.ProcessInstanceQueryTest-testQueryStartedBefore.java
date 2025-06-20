@Deployment(resources={"org/activiti/engine/test/api/oneTaskProcess.bpmn20.xml"}) public void testQueryStartedBefore() throws Exception {
assertEquals(1,processInstances.size());
}