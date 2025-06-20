@Test public void wrapperChars() throws Exception {
assertThat(testResult(WrapperChars.class),isSuccessful());
assertEquals(defaultPropertyTrialCount(),WrapperChars.iterations);//RW
WrapperChars.iterations=0;//RW
}