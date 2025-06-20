@Test public void testRequestLifeCycleFailureShouldCleanReservations() throws Throwable {
assertEquals(0,groupPlacementState.allocatedInstancesCount);
assertEquals(0,groupPlacementState.allocatedInstancesCount);
}