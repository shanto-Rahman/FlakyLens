@Test public void canceledAfterResponseIsDeliveredDoesNothing() throws Exception {
bodyRef.set(response.body().string());
latch.countDown();
latch.await();
assertEquals("A",bodyRef.get());
}