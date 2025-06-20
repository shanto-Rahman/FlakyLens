@Test public void testVerifyNonPublicWebMethodFails() throws NoSuchMethodException, SecurityException {
assertTrue(sut.failed());
assertEquals(1,sut.verificationFailures.size());
assertTrue(sut.verificationFailures.get(0) instanceof WebMethodIsNotPublic);
}