@Deployment(resources={"org/activiti/engine/test/api/oneTaskProcess.bpmn20.xml"}) public void testGetResourceAsStreamUnexistingDeployment(){
fail("ActivitiException expected");
assertEquals(org.activiti.engine.repository.Deployment.class,ae.getObjectClass());
}