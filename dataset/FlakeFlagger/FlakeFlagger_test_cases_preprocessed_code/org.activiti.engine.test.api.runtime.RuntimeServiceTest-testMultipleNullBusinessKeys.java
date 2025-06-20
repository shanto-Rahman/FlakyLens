@Deployment(resources={"org/activiti/engine/test/api/oneTaskProcess.bpmn20.xml"}) public void testMultipleNullBusinessKeys(){
assertNull(processInstance.getBusinessKey());
assertEquals(3,runtimeService.createProcessInstanceQuery().count());
}