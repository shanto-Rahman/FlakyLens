@Test public void testGroupResourcePlacementAfterSuccessfulProvisionOperation() throws Throwable {
assertEquals("Allocated instances count was not increased after provisioning",groupPlacementState.allocatedInstancesCount,allocatedInstancesCount + 1);
assertEquals("Placement was not cleaned",groupPlacementState.allocatedInstancesCount,allocatedInstancesCount);
}