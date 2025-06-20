@Test public void testSessionTimeout() throws DeploymentException {
assertEquals(1000,closeReason.getCloseCode().getCode());
latch.countDown();
assertTrue(latch.await(5,TimeUnit.SECONDS));
}