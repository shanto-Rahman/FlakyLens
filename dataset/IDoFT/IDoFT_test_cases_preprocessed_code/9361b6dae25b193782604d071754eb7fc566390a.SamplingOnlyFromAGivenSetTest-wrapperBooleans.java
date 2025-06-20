@Test public void wrapperBooleans() throws Exception {
assertThat(testResult(WrapperBooleans.class),isSuccessful());
assertEquals(defaultPropertyTrialCount(),WrapperBooleans.iterations);//RW
}