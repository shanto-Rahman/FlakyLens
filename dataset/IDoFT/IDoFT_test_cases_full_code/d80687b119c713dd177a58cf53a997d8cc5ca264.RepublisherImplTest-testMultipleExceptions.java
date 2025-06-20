@Test public void testMultipleExceptions() throws InterruptedException {
  republisher.start();
  Object publishedObject1=new Object();
  CountDownLatch latch=new CountDownLatch(11);
  publisher.publish(publishedObject1);
  EasyMock.expectLastCall().andAnswer(() -> {
    latch.countDown();
    throw new UncategorizedJmsException("");
  }
).times(10);
  publisher.publish(publishedObject1);
  EasyMock.expectLastCall().andAnswer(() -> {
    latch.countDown();
    return null;
  }
);
  control.replay();
  republisher.publicationFailed(publishedObject1);
  latch.await();
  assertEquals(11,republisher.getNumberFailedPublications());
  assertEquals(0,republisher.getSizeUnpublishedList());
  control.verify();
}
