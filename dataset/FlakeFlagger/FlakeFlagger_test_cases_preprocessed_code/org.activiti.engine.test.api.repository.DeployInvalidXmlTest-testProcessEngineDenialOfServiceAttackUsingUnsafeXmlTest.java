public void testProcessEngineDenialOfServiceAttackUsingUnsafeXmlTest() throws InterruptedException {
thread.start();
thread.join(waitTime);
assertTrue(runnable.finished);
}