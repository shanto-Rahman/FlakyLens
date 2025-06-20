@Test public void testRequestStateHasK8sInfo() throws Throwable {
assertNotNull(rs);
assertNotNull(rs.resourceLinks);
assertEquals(1,MockKubernetesApplicationAdapterService.getProvisionedComponents().size());
assertEquals(numberOfDeployments,MockKubernetesApplicationAdapterService.getCreatedDeploymentStates().size());
assertEquals(numberOfDeployments,rs.resourceLinks.size());
assertTrue(rs.resourceLinks.stream().allMatch(l -> l.contains(ManagementUriParts.KUBERNETES_DEPLOYMENTS)));
}