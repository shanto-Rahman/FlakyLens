@Deployment(resources={"org/activiti/engine/test/api/oneTaskProcess.bpmn20.xml"}) public void testFindProcessDefinitionById(){
assertEquals(1,definitions.size());
assertNotNull(processDefinition);
assertEquals("oneTaskProcess",processDefinition.getKey());
assertEquals("The One Task Process",processDefinition.getName());
assertEquals("This is a process for testing purposes",processDefinition.getDescription());
}