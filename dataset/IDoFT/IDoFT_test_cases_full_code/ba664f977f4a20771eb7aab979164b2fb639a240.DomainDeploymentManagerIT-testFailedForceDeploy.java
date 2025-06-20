@Test public void testFailedForceDeploy() throws Exception {
  final Deployment failedDeployment=createDefaultDeployment("test-failed-deployment.war").setServerGroups(Collections.<String>emptySet());
  assertFailed(deploymentManager.forceDeploy(failedDeployment));
  assertDeploymentDoesNotExist(failedDeployment);
}
