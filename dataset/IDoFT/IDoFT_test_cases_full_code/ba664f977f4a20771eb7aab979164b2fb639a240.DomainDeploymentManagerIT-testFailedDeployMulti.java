@Test public void testFailedDeployMulti() throws Exception {
  final Set<Deployment> failedDeployments=new HashSet<>();
  failedDeployments.add(createDefaultDeployment("test-failed-deployment-1.war"));
  failedDeployments.add(createDefaultDeployment("test-failed-deployment-2.war").setServerGroups(Collections.<String>emptySet()));
  assertFailed(deploymentManager.deploy(failedDeployments));
  for (  Deployment failedDeployment : failedDeployments) {
    assertDeploymentDoesNotExist(failedDeployment);
  }
}
