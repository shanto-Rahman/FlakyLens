@Test(timeout=2000) public void testIssue() throws Exception {
Assert.fail("Exception should be thrown");
Assert.fail("Exception should be thrown");
Assert.fail("Exception should be thrown");
Assert.fail("Exception should be thrown");
countServerDownLatch.countDown();
fail("There should be no onError!");
countServerDownLatch.await();
}