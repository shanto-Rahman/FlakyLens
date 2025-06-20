@Test public void wrapperDoubles() throws Exception {
assertThat(testResult(WrapperDoubles.class),isSuccessful());
assertEquals(defaultPropertyTrialCount(),WrapperDoubles.iterations);//RW
}