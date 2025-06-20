@Test public void testContainerClusteringTaskAddContainersServiceRemove() throws Throwable {
assertEquals(0,containersNumberBeforeProvisioning);
assertEquals(3,containersNumberBeforeClustering);
assertEquals(2,containersNumberAfterClustering);
assertEquals(8,placementState.availableInstancesCount);
assertEquals(2,placementState.allocatedInstancesCount);
}