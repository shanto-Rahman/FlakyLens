@Test public void acrossParametersOfSameTypeWithOneConstant() throws Exception {
assertThat(testResult(ParametersOfSameTypeWithOneConstant.class),isSuccessful());
assertEquals(defaultPropertyTrialCount(),ParametersOfSameTypeWithOneConstant.iterations);//RW
ParametersOfSameTypeWithOneConstant.iterations=0;//RW
}