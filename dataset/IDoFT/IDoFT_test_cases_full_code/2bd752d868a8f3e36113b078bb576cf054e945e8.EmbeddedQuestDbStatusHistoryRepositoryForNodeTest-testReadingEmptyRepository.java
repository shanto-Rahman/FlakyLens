@Test public void testReadingEmptyRepository() throws Exception {
  final StatusHistory nodeStatusHistory=testSubject.getNodeStatusHistory(START,END);
  final GarbageCollectionHistory garbageCollectionHistory=testSubject.getGarbageCollectionHistory(START,END);
  Assert.assertTrue(nodeStatusHistory.getStatusSnapshots().isEmpty());
  Assert.assertTrue(garbageCollectionHistory.getGarbageCollectionStatuses("gc1").isEmpty());
  Assert.assertTrue(garbageCollectionHistory.getGarbageCollectionStatuses("gc2").isEmpty());
}
