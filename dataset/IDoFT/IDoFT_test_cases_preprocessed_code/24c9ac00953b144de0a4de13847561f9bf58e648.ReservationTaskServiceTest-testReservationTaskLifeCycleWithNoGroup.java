@Test public void testReservationTaskLifeCycleWithNoGroup() throws Throwable {
assertNotNull(task);
assertEquals(groupPlacementState.documentSelfLink,task.groupResourcePlacementLink);
assertEquals(totalAllocatedResources,groupPlacementState.allocatedInstancesCount);
}