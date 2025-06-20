@Test public void testReservationRemovalTaskLife() throws Throwable {
  GroupResourcePlacementState placementState=doPost(TestRequestStateFactory.createGroupResourcePlacementState(),GroupResourcePlacementService.FACTORY_LINK);
  String descLink=containerDesc.documentSelfLink;
  int count=5;
  boolean expectFailure=false;
  placementState=makeResourcePlacementReservationRequest(count,descLink,placementState,expectFailure);
  assertEquals(placementState.allocatedInstancesCount,count);
  ReservationRemovalTaskState task=new ReservationRemovalTaskState();
  task.resourceDescriptionLink=descLink;
  task.resourceCount=count;
  task.serviceTaskCallback=ServiceTaskCallback.createEmpty();
  task.groupResourcePlacementLink=placementState.documentSelfLink;
  task=doPost(task,ReservationRemovalTaskFactoryService.SELF_LINK);
  assertNotNull(task);
  waitForTaskSuccess(task.documentSelfLink,ReservationRemovalTaskState.class);
  placementState=getDocument(GroupResourcePlacementState.class,placementState.documentSelfLink);
  assertEquals(placementState.allocatedInstancesCount,0);
  host.log("second reservation removal starting:");
  task=new ReservationRemovalTaskState();
  task.resourceDescriptionLink=descLink;
  task.resourceCount=count;
  task.serviceTaskCallback=ServiceTaskCallback.createEmpty();
  task.groupResourcePlacementLink=placementState.documentSelfLink;
  task=doPost(task,ReservationRemovalTaskFactoryService.SELF_LINK);
  host.log("second reservation removal started");
  waitForTaskSuccess(task.documentSelfLink,ReservationRemovalTaskState.class);
  placementState=getDocument(GroupResourcePlacementState.class,placementState.documentSelfLink);
  assertEquals(placementState.allocatedInstancesCount,0);
}
