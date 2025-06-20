@Test public void testMultiplePublicationsWithExceptions() throws InterruptedException {
  republisher.start();
  Object publishedObject1=new Object();
  Object publishedObject2=new Object();
  Object publishedObject3=new Object();
  CountDownLatch latch=new CountDownLatch(18);
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
  publisher.publish(publishedObject2);
  EasyMock.expectLastCall().andAnswer(() -> {
    latch.countDown();
    throw new UncategorizedJmsException("");
  }
).times(5);
  publisher.publish(publishedObject2);
  EasyMock.expectLastCall().andAnswer(() -> {
    latch.countDown();
    return null;
  }
);
  publisher.publish(publishedObject3);
  EasyMock.expectLastCall().andAnswer(() -> {
    latch.countDown();
    return null;
  }
);
  control.replay();
  republisher.publicationFailed(publishedObject1);
  republisher.publicationFailed(publishedObject2);
  republisher.publicationFailed(publishedObject3);
  latch.await();
  assertEquals(11 + 6 + 1,republisher.getNumberFailedPublications());
  assertEquals(0,republisher.getSizeUnpublishedList());
  control.verify();
}
