@Test public void testMultiplePublicationsWithExceptions() throws InterruptedException {
latch.await();
assertEquals(11 + 6 + 1,republisher.getNumberFailedPublications());
assertEquals(0,republisher.getSizeUnpublishedList());
}