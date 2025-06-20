@Deployment(resources={"org/activiti/engine/test/api/oneTaskProcess.bpmn20.xml","org/activiti/engine/test/api/runtime/oneTaskProcess2.bpmn20.xml"}) public void testHistoricTaskInstanceQueryByDeploymentId(){
assertEquals(5,taskInstanceQuery.count());
assertNotNull(taskInstances);
assertEquals(5,taskInstances.size());
assertEquals(0,taskInstanceQuery.count());
}