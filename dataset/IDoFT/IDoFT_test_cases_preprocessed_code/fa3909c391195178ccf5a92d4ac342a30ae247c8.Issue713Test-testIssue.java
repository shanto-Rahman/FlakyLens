@Test(timeout=2000) public void testIssue() throws Exception {
Assert.fail("Exception during connect!");
countDownLatchConnect.await();
countDownLatchString.await();
countDownLatchBytebuffer.await();
countDownLatchBytebuffer.await();
countDownLatchString.await();
countDownLatchBytebuffer.await();
}