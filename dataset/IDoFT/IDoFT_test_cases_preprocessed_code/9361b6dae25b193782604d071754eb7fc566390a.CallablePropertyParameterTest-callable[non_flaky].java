@Test public void callable() throws Exception {
assertThat(testResult(CallableOfInt.class),isSuccessful());
assertEquals(defaultPropertyTrialCount(),CallableOfInt.iterations);//RW
CallableOfInt.iterations=0;//RW
}