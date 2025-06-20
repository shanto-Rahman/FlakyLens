@Test(timeout=30000) public void testStateTooLargeExceptionThrownOnSetState() throws InterruptedException {
Assert.fail("Expected StateTooLargeException");
Thread.sleep(1000L);
Assert.fail("Expected StateTooLargeException but " + e.getClass() + " was thrown",e);
}