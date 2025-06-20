@Deployment(resources={"org/activiti/engine/test/api/oneTaskProcess.bpmn20.xml"}) public void testStartProcessInstanceWithBusinessKey(){
assertNotNull(processInstance);
assertEquals("123",processInstance.getBusinessKey());
assertEquals(1,runtimeService.createProcessInstanceQuery().processDefinitionKey("oneTaskProcess").count());
assertNotNull(processInstance);
assertEquals(2,runtimeService.createProcessInstanceQuery().processDefinitionKey("oneTaskProcess").count());
assertEquals("value",runtimeService.getVariable(processInstance.getId(),"var"));
assertNotNull(processInstance);
assertEquals(3,runtimeService.createProcessInstanceQuery().processDefinitionKey("oneTaskProcess").count());
assertNotNull(processInstance);
assertEquals(4,runtimeService.createProcessInstanceQuery().processDefinitionKey("oneTaskProcess").count());
assertEquals("value2",runtimeService.getVariable(processInstance.getId(),"var"));
}