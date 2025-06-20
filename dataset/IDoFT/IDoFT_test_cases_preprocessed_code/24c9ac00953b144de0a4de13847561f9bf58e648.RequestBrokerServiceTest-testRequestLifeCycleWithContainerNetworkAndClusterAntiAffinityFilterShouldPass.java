@Test public void testRequestLifeCycleWithContainerNetworkAndClusterAntiAffinityFilterShouldPass() throws Throwable {
assertNotNull(compositeDesc);
assertEquals(1,request.resourceLinks.size());
if (link.startsWith(ContainerNetworkService.FACTORY_LINK)) {
if (containerLink1 == null) {
}
}
if (cluster1Hosts.contains(cont1.parentLink)) {
if (cluster2Hosts.contains(cont1.parentLink)) {
}
}
assertNotNull(selectedCluster);
assertTrue(containersAreProvisionedOnTheSameCluster);
assertTrue(networkProvisionedOnTheSameCluster);
assertEquals(cc.documentSelfLink,cont1.compositeComponentLink);
assertEquals(cc.documentSelfLink,cont2.compositeComponentLink);
assertTrue((network.compositeComponentLinks.size() == 1) && network.compositeComponentLinks.contains(cc.documentSelfLink));
assertEquals(SCALE_SIZE,request.resourceLinks.size());
assertTrue(scaledContainersAreProvisionedOnTheSameCluster);
assertEquals(SCALE_SIZE + 3,cc.componentLinks.size());
}