@Deployment(resources={"org/activiti/engine/test/api/oneTaskProcess.bpmn20.xml"}) public void testStartProcessInstanceById(){
assertEquals(1,processDefinitions.size());
assertEquals("oneTaskProcess",processDefinition.getKey());
assertNotNull(processDefinition.getId());
}