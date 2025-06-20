@Test public void testChildrenListener() throws InterruptedException {
countDownLatch.countDown();
countDownLatch.await();
}