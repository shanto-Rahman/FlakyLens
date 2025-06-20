@Deployment(resources={"org/activiti/engine/test/api/oneTaskProcess.bpmn20.xml"}) public void testGetResourceAsStreamUnexistingResourceInExistingDeployment(){
fail("ActivitiException expected");
assertEquals(InputStream.class,ae.getObjectClass());
}