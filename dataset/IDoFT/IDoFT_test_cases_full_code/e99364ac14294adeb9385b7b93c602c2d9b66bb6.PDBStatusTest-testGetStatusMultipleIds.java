@Test public void testGetStatusMultipleIds() throws IOException {
  String[] ids={"1HHB","3HHB","4HHB"};
  Status[] statuses=PDBStatus.getStatus(ids);
  Assert.assertEquals(Status.REMOVED,statuses[0]);
  Assert.assertEquals(Status.CURRENT,statuses[1]);
  Assert.assertEquals(Status.CURRENT,statuses[2]);
}
