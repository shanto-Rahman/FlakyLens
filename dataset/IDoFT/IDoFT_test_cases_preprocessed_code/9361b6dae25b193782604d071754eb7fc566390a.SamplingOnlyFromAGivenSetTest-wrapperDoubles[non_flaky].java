@Test public void wrapperDoubles() throws Exception {
assertThat(testResult(WrapperDoubles.class),isSuccessful());
assertEquals(defaultPropertyTrialCount(),WrapperDoubles.iterations);//RW
WrapperDoubles.iterations=0;//RW
}