@Test public void testMultiThreadSetAndGet() throws InterruptedException {
Assert.assertTrue("set is not equals get",Objects.equals(testVal1,internalThreadLocal.get()));
countDownLatch.countDown();
t1.start();
Assert.assertTrue("set is not equals get",Objects.equals(testVal2,internalThreadLocal.get()));
countDownLatch.countDown();
t2.start();
countDownLatch.await();
}