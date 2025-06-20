@Test public void acrossParametersOfSameArrayTypeWithOneConstant() throws Exception {
assertThat(testResult(ParametersOfSameArrayTypeWithOneConstant.class),isSuccessful());
assertEquals(defaultPropertyTrialCount(),ParametersOfSameArrayTypeWithOneConstant.iterations);//RW
}