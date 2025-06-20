@Deployment(resources={"org/activiti/engine/test/api/runtime/concurrentExecution.bpmn20.xml"}) public void testHistoricVariableInstancesOnParallelExecution(){
assertEquals(1,historyService.createHistoricProcessInstanceQuery().variableValueEquals("rootValue","test").count());
assertEquals(1,historyService.createHistoricProcessInstanceQuery().variableValueEquals("parallelValue1","Receive Payment").count());
assertEquals(1,historyService.createHistoricProcessInstanceQuery().variableValueEquals("parallelValue1","Ship Order").count());
assertEquals(1,historyService.createHistoricProcessInstanceQuery().variableValueEquals("parallelValue2","test").count());
}