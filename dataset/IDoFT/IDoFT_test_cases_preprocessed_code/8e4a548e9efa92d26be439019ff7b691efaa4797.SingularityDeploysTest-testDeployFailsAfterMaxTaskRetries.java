@Test public void testDeployFailsAfterMaxTaskRetries(){
Assertions.assertTrue(!deployManager.getDeployResult(requestId,firstDeployId).isPresent());
Assertions.assertEquals(deployManager.getPendingDeploys().get(0).getCurrentDeployState(),DeployState.WAITING);
Assertions.assertEquals(deployManager.getDeployResult(requestId,firstDeployId).get().getDeployState(),DeployState.FAILED);
}