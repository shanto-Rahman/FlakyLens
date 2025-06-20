@Test public void acrossParametersOfSameType() throws Exception {
assertThat(testResult(ParametersOfSameType.class),isSuccessful());
assertEquals(defaultPropertyTrialCount(),ParametersOfSameType.iterations);//RW
ParametersOfSameType.iterations=0;//RW
}