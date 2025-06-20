@Deployment(resources={"org/activiti/engine/test/api/oneTaskProcess.bpmn20.xml"}) public void testClashingValues() throws Exception {
assertEquals(1,foundInstances.size());
assertEquals(processInstance.getId(),foundInstances.get(0).getId());
}