@Test public void testGetStatusMultipleIds() throws IOException {
Assert.assertEquals(Status.REMOVED,statuses[0]);
Assert.assertEquals(Status.CURRENT,statuses[1]);
Assert.assertEquals(Status.CURRENT,statuses[2]);
}