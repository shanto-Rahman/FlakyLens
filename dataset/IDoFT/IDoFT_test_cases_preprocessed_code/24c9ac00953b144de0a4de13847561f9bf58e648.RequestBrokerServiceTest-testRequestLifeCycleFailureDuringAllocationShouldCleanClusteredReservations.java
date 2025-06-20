@Test public void testRequestLifeCycleFailureDuringAllocationShouldCleanClusteredReservations() throws Throwable {
assertEquals(0,groupPlacementState.allocatedInstancesCount);
assertEquals(0,groupPlacementState.allocatedInstancesCount);
}