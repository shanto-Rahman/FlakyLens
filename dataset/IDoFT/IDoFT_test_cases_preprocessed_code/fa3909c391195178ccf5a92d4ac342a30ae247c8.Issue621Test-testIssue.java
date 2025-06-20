@Test public void testIssue() throws Exception {
countDownLatch.countDown();
countServerDownLatch.countDown();
countServerDownLatch.await();
countDownLatch.await();
assertTrue("There was an error using System.err",!wasError);
}