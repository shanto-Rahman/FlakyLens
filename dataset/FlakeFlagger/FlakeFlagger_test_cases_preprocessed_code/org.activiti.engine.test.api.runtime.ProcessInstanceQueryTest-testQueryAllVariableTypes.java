@Deployment(resources={"org/activiti/engine/test/api/oneTaskProcess.bpmn20.xml"}) public void testQueryAllVariableTypes() throws Exception {
assertNotNull(processInstances);
assertEquals(1,processInstances.size());
assertEquals(processInstance.getId(),processInstances.get(0).getId());
}