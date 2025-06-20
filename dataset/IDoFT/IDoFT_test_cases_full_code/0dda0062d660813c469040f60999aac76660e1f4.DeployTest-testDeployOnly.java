@Test public void testDeployOnly() throws Exception {
  if (deploymentManager.hasDeployment(DEPLOYMENT_NAME,DEFAULT_SERVER_GROUP)) {
    deploymentManager.undeploy(UndeployDescription.of(DEPLOYMENT_NAME).addServerGroups(DEFAULT_SERVER_GROUPS));
  }
  executeAndVerifyDeploymentExists("deploy-only","deploy-webarchive-pom.xml");
  deploymentManager.undeploy(UndeployDescription.of(DEPLOYMENT_NAME).addServerGroups(DEFAULT_SERVER_GROUPS));
}
