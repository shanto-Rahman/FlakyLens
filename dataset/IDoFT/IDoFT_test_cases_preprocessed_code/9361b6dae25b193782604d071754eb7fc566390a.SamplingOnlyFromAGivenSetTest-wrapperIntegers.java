@Test public void wrapperIntegers() throws Exception {
assertThat(testResult(WrapperIntegers.class),isSuccessful());
assertEquals(defaultPropertyTrialCount(),WrapperIntegers.iterations);//RW
}