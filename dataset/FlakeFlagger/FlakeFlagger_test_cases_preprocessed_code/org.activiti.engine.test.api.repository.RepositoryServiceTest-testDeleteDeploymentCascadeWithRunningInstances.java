@Deployment(resources={"org/activiti/engine/test/api/oneTaskProcess.bpmn20.xml"}) public void testDeleteDeploymentCascadeWithRunningInstances(){
assertEquals(1,processDefinitions.size());
}