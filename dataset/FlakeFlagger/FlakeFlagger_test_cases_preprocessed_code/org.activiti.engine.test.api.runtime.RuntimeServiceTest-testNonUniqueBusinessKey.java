@Deployment(resources={"org/activiti/engine/test/api/oneTaskProcess.bpmn20.xml"}) public void testNonUniqueBusinessKey(){
assertEquals(2,runtimeService.createProcessInstanceQuery().processInstanceBusinessKey("123").count());
}