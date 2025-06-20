@Deployment(resources={"org/activiti/engine/test/api/oneTaskProcess.bpmn20.xml","org/activiti/engine/test/api/runtime/oneTaskProcess2.bpmn20.xml"}) public void testHistoricTaskInstanceOrQueryByDeploymentId(){
assertEquals(5,taskInstanceQuery.count());
assertNotNull(taskInstances);
assertEquals(5,taskInstances.size());
assertEquals(0,taskInstanceQuery.count());
assertEquals(5,taskInstanceQuery.count());
assertEquals(0,taskInstanceQuery.count());
assertEquals(4,taskInstanceQuery.count());
assertEquals(1,taskInstanceQuery.count());
assertEquals(1,taskInstanceQuery.count());
assertEquals(1,taskInstanceQuery.count());
assertEquals(0,taskInstanceQuery.count());
}