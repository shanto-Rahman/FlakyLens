@Test public void testReadingLimitedByPreferredDataPoints() throws Exception {
testSubject.capture(new NodeStatus(),givenSimpleRootProcessGroupStatus(),new ArrayList<>(),new Date(INSERTED_AT.getTime() - TimeUnit.MINUTES.toMillis(8)));
testSubject.capture(new NodeStatus(),givenSimpleRootProcessGroupStatus(),new ArrayList<>(),new Date(INSERTED_AT.getTime() - TimeUnit.MINUTES.toMillis(7)));
testSubject.capture(new NodeStatus(),givenSimpleRootProcessGroupStatus(),new ArrayList<>(),new Date(INSERTED_AT.getTime() - TimeUnit.MINUTES.toMillis(6)));
testSubject.capture(new NodeStatus(),givenSimpleRootProcessGroupStatus(),new ArrayList<>(),new Date(INSERTED_AT.getTime() - TimeUnit.MINUTES.toMillis(5)));
Assert.assertEquals(3,result.getStatusSnapshots().size());
Assert.assertEquals(new Date(INSERTED_AT.getTime() - TimeUnit.MINUTES.toMillis(7)),result.getStatusSnapshots().get(0).getTimestamp());
Assert.assertEquals(new Date(INSERTED_AT.getTime() - TimeUnit.MINUTES.toMillis(6)),result.getStatusSnapshots().get(1).getTimestamp());
Assert.assertEquals(new Date(INSERTED_AT.getTime() - TimeUnit.MINUTES.toMillis(5)),result.getStatusSnapshots().get(2).getTimestamp());
}