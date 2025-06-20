@Test public void testVerifyFails() throws DeploymentUnitProcessingException {
assertTrue(sut.failed());
assertEquals(5,sut.verificationFailures.size());
}