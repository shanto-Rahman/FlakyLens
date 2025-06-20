@Test public void wrapperBooleans() throws Exception {
assertThat(testResult(WrapperBooleans.class),isSuccessful());
assertEquals(defaultPropertyTrialCount(),WrapperBooleans.iterations);//RW
assertEquals(singletonList(false),WrapperBooleans.values.subList(0,1));
WrapperBooleans.iterations=0;//RW
}