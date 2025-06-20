public void testDeploySameFileTwice(){
assertEquals(1,deploymentResources.size());
assertEquals(bpmnResourceName,deploymentResources.get(0));
assertEquals(1,deploymentList.size());
}