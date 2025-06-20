@Test public void acrossParametersOfSameArrayType() throws Exception {
assertThat(testResult(ParametersOfSameArrayType.class),isSuccessful());
assertEquals(defaultPropertyTrialCount(),ParametersOfSameArrayType.iterations);//RW
ParametersOfSameArrayType.iterations=0;//RW
}