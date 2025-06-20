@Deployment(resources={"org/activiti/engine/test/api/oneTaskProcess.bpmn20.xml","org/activiti/engine/test/api/runtime/oneTaskProcess2.bpmn20.xml"}) public void testHistoricProcessInstanceQueryByDeploymentIdIn(){
assertEquals(5,processInstanceQuery.count());
assertNotNull(processInstances);
assertEquals(5,processInstances.size());
assertEquals(0,processInstanceQuery.count());
}