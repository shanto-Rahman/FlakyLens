@Test public void testGroupResourcePlacementAfterFailedProvisionOperation() throws Throwable {
assertEquals("Allocated instances count is not correct",groupPlacementState.allocatedInstancesCount,allocatedInstancesCount + 1);
assertEquals("Allocated instances count is not correct after a failed provisioning",groupPlacementState.allocatedInstancesCount,allocatedInstancesCount + 1);
}