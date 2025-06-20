@Test public void testVerifyWebMethodSucceeds() throws NoSuchMethodException, SecurityException {
assertFalse(sut.failed());
assertEquals(0,sut.verificationFailures.size());
}