@Test public void testReservationTaskLifeCycleWithMemoryLimitInRange() throws Throwable {
assertNotNull(task);
assertEquals(groupPlacementStateEnoughMemory.maxNumberInstances - task.resourceCount,groupPlacementStateEnoughMemory.availableInstancesCount);
assertEquals(groupPlacementStateEnoughMemory.documentSelfLink,task.groupResourcePlacementLink);
}