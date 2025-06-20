@Test public void wrapperShorts() throws Exception {
assertThat(testResult(WrapperShorts.class),isSuccessful());
assertEquals(defaultPropertyTrialCount(),WrapperShorts.iterations);//RW
WrapperShorts.iterations=0;//RW
}