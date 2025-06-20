public void testDeploymentCategory(){
assertEquals(4,query.list().size());
assertEquals(expectedDeploymentNames,deploymentNames);
assertEquals(expectedDeploymentNames,deploymentNames);
assertNull(deploymentNoCategory.getCategory());
assertEquals("newCategory",deploymentNoCategory.getCategory());
if (noCategoryDeploymentId != null) undeploy(noCategoryDeploymentId);
if (deploymentOneId != null) undeploy(deploymentOneId);
if (deploymentTwoV1Id != null) undeploy(deploymentTwoV1Id);
if (deploymentTwoV2Id != null) undeploy(deploymentTwoV2Id);
if (deploymentTwoNoCategory != null) undeploy(deploymentTwoNoCategory);
}