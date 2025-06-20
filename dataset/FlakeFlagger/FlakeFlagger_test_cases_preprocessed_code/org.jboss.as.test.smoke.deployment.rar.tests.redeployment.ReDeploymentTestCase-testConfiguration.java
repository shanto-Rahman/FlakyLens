/** 
 * Test configuration
 * @throws Throwable Thrown if case of an error
 */
@Test public void testConfiguration() throws Throwable {
deployer.deploy(deploymentName);//RW
deployer.undeploy(deploymentName);//RW
deployer.deploy(deploymentName);//RW
assertNotNull("AO1 not found",adminObject1);
deployer.undeploy(deploymentName);//RW
}