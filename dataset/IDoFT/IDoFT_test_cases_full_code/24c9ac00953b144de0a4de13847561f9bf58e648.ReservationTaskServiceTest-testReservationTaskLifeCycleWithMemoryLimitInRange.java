@Test public void testReservationTaskLifeCycleWithMemoryLimitInRange() throws Throwable {
  GroupResourcePlacementState groupPlacementStateLessMemory=TestRequestStateFactory.createGroupResourcePlacementState();
  groupPlacementStateLessMemory.memoryLimit=containerDesc.memoryLimit * 2 - 1;
  groupPlacementStateLessMemory=doPost(groupPlacementStateLessMemory,GroupResourcePlacementService.FACTORY_LINK);
  addForDeletion(groupPlacementStateLessMemory);
  ReservationTaskState task=new ReservationTaskState();
  task.tenantLinks=groupPlacementStateLessMemory.tenantLinks;
  task.resourceCount=2;
  task.resourceDescriptionLink=containerDesc.documentSelfLink;
  task.serviceTaskCallback=ServiceTaskCallback.createEmpty();
  task=doPost(task,ReservationTaskFactoryService.SELF_LINK);
  task=waitForTaskError(task.documentSelfLink,ReservationTaskState.class);
  GroupResourcePlacementState groupPlacementStateEnoughMemory=TestRequestStateFactory.createGroupResourcePlacementState();
  groupPlacementStateEnoughMemory.memoryLimit=containerDesc.memoryLimit * 2 + 1;
  groupPlacementStateEnoughMemory=doPost(groupPlacementStateEnoughMemory,GroupResourcePlacementService.FACTORY_LINK);
  addForDeletion(groupPlacementStateEnoughMemory);
  task=new ReservationTaskState();
  task.tenantLinks=groupPlacementStateLessMemory.tenantLinks;
  task.resourceCount=2;
  task.resourceDescriptionLink=containerDesc.documentSelfLink;
  task.serviceTaskCallback=ServiceTaskCallback.createEmpty();
  task=doPost(task,ReservationTaskFactoryService.SELF_LINK);
  assertNotNull(task);
  task=waitForTaskSuccess(task.documentSelfLink,ReservationTaskState.class);
  groupPlacementStateEnoughMemory=getDocument(GroupResourcePlacementState.class,groupPlacementStateEnoughMemory.documentSelfLink);
  assertEquals(groupPlacementStateEnoughMemory.maxNumberInstances - task.resourceCount,groupPlacementStateEnoughMemory.availableInstancesCount);
  assertEquals(groupPlacementStateEnoughMemory.documentSelfLink,task.groupResourcePlacementLink);
}
