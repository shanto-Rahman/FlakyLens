@Test public void testReadingEmptyRepository() throws Exception {
Assert.assertTrue(nodeStatusHistory.getStatusSnapshots().isEmpty());
Assert.assertTrue(garbageCollectionHistory.getGarbageCollectionStatuses("gc1").isEmpty());
Assert.assertTrue(garbageCollectionHistory.getGarbageCollectionStatuses("gc2").isEmpty());
}