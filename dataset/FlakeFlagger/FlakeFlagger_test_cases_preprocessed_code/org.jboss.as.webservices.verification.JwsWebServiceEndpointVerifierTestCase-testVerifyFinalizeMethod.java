@Test public void testVerifyFinalizeMethod(){
assertTrue(sut.failed());
assertEquals(1,sut.verificationFailures.size());
assertTrue(sut.verificationFailures.get(0) instanceof ImplementationHasFinalize);
}