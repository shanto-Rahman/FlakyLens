@Test public void testReservationTaskLifeCycleWithNoGroup() throws Throwable {
  GroupResourcePlacementState groupPlacementState=TestRequestStateFactory.createGroupResourcePlacementState();
  groupPlacementState.tenantLinks=null;
  groupPlacementState.maxNumberInstances=100;
  groupPlacementState=doPost(groupPlacementState,GroupResourcePlacementService.FACTORY_LINK);
  addForDeletion(groupPlacementState);
  GroupResourcePlacementState defaultPlacementState=TestRequestStateFactory.createGroupResourcePlacementState();
  defaultPlacementState.maxNumberInstances=100;
  defaultPlacementState=doPost(defaultPlacementState,GroupResourcePlacementService.FACTORY_LINK);
  addForDeletion(defaultPlacementState);
  doPost(TestRequestStateFactory.createGroupResourcePlacementState(),GroupResourcePlacementService.FACTORY_LINK);
  ReservationTaskState taskTemplate=new ReservationTaskState();
  taskTemplate.tenantLinks=null;
  taskTemplate.resourceDescriptionLink=containerDesc.documentSelfLink;
  taskTemplate.resourceCount=5;
  taskTemplate.serviceTaskCallback=ServiceTaskCallback.createEmpty();
  int totalAllocatedResources=0;
  int maxRequests=5;
  for (int i=0; i < maxRequests; i++) {
    ReservationTaskState task=doPost(taskTemplate,ReservationTaskFactoryService.SELF_LINK);
    assertNotNull(task);
    task=waitForTaskSuccess(task.documentSelfLink,ReservationTaskState.class);
    totalAllocatedResources+=task.resourceCount;
    groupPlacementState=getDocument(GroupResourcePlacementState.class,groupPlacementState.documentSelfLink);
    assertEquals(groupPlacementState.documentSelfLink,task.groupResourcePlacementLink);
    assertEquals(totalAllocatedResources,groupPlacementState.allocatedInstancesCount);
  }
}
