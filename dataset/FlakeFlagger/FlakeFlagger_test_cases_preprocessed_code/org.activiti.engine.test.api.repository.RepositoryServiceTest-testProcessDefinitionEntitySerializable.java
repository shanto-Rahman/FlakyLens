@Deployment(resources={"org/activiti/engine/test/api/oneTaskProcess.bpmn20.xml"}) public void testProcessDefinitionEntitySerializable(){
assertTrue(bytes.length > 0);
fail();
}