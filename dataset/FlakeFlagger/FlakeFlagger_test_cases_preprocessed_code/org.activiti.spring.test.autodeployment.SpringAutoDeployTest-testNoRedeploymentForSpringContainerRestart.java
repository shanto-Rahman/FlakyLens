public void testNoRedeploymentForSpringContainerRestart() throws Exception {
assertEquals(1,deploymentQuery.count());
assertEquals(3,processDefinitionQuery.count());
assertEquals(1,deploymentQuery.count());
assertEquals(3,processDefinitionQuery.count());
}