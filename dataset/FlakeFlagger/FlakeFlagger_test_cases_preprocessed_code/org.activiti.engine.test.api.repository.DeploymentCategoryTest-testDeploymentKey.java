public void testDeploymentKey(){
assertEquals(4,query.list().size());
assertEquals(expectedDeploymentNames,deploymentNames);
assertNull(deploymentNoCategory.getCategory());
assertEquals("newKey",deploymentNoCategory.getKey());
if (noKeyDeploymentId != null) undeploy(noKeyDeploymentId);
if (deploymentOneId != null) undeploy(deploymentOneId);
if (deploymentTwoV1Id != null) undeploy(deploymentTwoV1Id);
if (deploymentTwoV2Id != null) undeploy(deploymentTwoV2Id);
if (deploymentTwoNoKey != null) undeploy(deploymentTwoNoKey);
}