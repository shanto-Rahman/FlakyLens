@Test public void testConfiguration() throws Throwable {
assertNotNull("Deployment metadata for ear not found",managementClient.getProtocolMetaData(deploymentName));//RW
address.add("deployment",deploymentName).add("subdeployment",subdeploymentName).add("subsystem","resource-adapters");//RW
}