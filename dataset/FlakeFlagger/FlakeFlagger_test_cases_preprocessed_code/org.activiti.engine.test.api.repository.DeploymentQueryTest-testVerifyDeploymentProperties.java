public void testVerifyDeploymentProperties(){
assertEquals("org/activiti/engine/test/repository/one.bpmn20.xml",deploymentOne.getName());
assertEquals(deploymentOneId,deploymentOne.getId());
assertEquals("org/activiti/engine/test/repository/two.bpmn20.xml",deploymentTwo.getName());
assertEquals(deploymentTwoId,deploymentTwo.getId());
assertEquals("org/activiti/engine/test/repository/one.bpmn20.xml",deployments.get(0).getName());
assertEquals(1,deployments.size());
assertEquals(2,repositoryService.createDeploymentQuery().orderByDeploymentId().asc().list().size());
assertEquals(2,repositoryService.createDeploymentQuery().orderByDeploymenTime().asc().list().size());
}