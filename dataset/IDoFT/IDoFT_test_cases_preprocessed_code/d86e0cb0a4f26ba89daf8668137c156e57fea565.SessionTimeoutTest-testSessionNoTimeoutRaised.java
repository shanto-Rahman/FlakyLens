@Test public void testSessionNoTimeoutRaised() throws DeploymentException {
assertEquals(POSITIVE,message);
Thread.sleep(250);
Thread.sleep(250);
assertTrue(latch.await(2,TimeUnit.SECONDS));
}