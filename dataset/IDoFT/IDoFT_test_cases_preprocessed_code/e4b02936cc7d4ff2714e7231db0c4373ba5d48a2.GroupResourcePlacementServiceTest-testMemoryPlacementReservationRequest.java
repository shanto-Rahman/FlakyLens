@Test public void testMemoryPlacementReservationRequest() throws Throwable {
assertEquals(CONTAINER_MEMORY / 2,placementState.availableMemory);//RW
assertEquals(7,placementState.availableInstancesCount);
assertEquals(3,placementState.allocatedInstancesCount);
assertEquals(0,noLimitsGroupResourcePlacement.availableMemory);
assertEquals(0,noLimitsGroupResourcePlacement.memoryLimit);
assertEquals(9,noLimitsGroupResourcePlacement.availableInstancesCount);
assertEquals(1,noLimitsGroupResourcePlacement.allocatedInstancesCount);
assertEquals(0,noLimitsGroupResourcePlacement.availableMemory);
assertEquals(0,noLimitsGroupResourcePlacement.memoryLimit);
assertEquals(8,noLimitsGroupResourcePlacement.availableInstancesCount);
assertEquals(2,noLimitsGroupResourcePlacement.allocatedInstancesCount);
}