@Test public void testWritingThenReadingComponents() throws Exception {
  testSubject.capture(givenNodeStatus(),new ProcessGroupStatus(),givenGarbageCollectionStatuses(INSERTED_AT),INSERTED_AT);
  givenWaitUntilPersisted();
  final StatusHistory nodeStatusHistory=testSubject.getNodeStatusHistory(START,END);
  assertNodeStatusHistory(nodeStatusHistory.getStatusSnapshots().get(0));
  final GarbageCollectionHistory garbageCollectionHistory=testSubject.getGarbageCollectionHistory(START,END);
  assertGc1Status(garbageCollectionHistory.getGarbageCollectionStatuses("gc1"));
  assertGc2Status(garbageCollectionHistory.getGarbageCollectionStatuses("gc2"));
}
