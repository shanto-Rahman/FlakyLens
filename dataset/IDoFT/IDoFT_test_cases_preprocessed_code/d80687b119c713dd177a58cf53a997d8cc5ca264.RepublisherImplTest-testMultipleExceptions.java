@Test public void testMultipleExceptions() throws InterruptedException {
latch.await();
assertEquals(11,republisher.getNumberFailedPublications());
assertEquals(0,republisher.getSizeUnpublishedList());
}