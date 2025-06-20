@org.junit.Test public void testCloseFrame() throws Exception {
connected.set(true);
closeCount.incrementAndGet();
clientLatch.countDown();
clientLatch.await();
Assert.assertEquals(code,reason.get().getCloseCode().getCode());
Assert.assertEquals(reasonText,reason.get().getReasonPhrase());
Assert.assertEquals(1,closeCount.get());
}