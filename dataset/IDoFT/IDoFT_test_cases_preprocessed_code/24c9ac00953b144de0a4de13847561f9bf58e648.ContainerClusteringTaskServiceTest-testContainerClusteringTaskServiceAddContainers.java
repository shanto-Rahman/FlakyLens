@Test public void testContainerClusteringTaskServiceAddContainers() throws Throwable {
assertEquals(0,containersNumberBeforeProvisioning);
assertEquals(3,containersNumberBeforeClustering);
assertEquals(5,containersNumberAfterClustering);
assertTrue(containersIdsAfterClustering.containsAll(containersIdsBeforeClustering));
assertEquals(5,placementState.availableInstancesCount);
assertEquals(5,placementState.allocatedInstancesCount);
}