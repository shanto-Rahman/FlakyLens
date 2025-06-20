@Deployment(resources={"org/activiti/engine/test/api/runtime/superProcess.bpmn20.xml","org/activiti/engine/test/api/runtime/subProcess.bpmn20.xml"}) public void testOrQueryBySubProcessInstanceId(){
assertNotNull(subProcessInstance);
assertEquals(superProcessInstance.getId(),runtimeService.createProcessInstanceQuery().or().subProcessInstanceId(subProcessInstance.getId()).processDefinitionId("undefined").singleResult().getId());
}