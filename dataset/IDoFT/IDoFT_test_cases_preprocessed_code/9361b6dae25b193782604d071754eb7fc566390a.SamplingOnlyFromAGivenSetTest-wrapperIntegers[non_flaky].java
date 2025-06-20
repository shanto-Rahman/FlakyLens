@Test public void wrapperIntegers() throws Exception {
assertThat(testResult(WrapperIntegers.class),isSuccessful());
assertEquals(defaultPropertyTrialCount(),WrapperIntegers.iterations);//RW
WrapperIntegers.iterations=0;//RW
}