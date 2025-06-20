@Test public void acrossParametersOfSameParameterizedTypeWithOneConstant() throws Exception {
assertThat(testResult(ParametersOfSameParameterizedTypeWithOneConstant.class),isSuccessful());
assertEquals(defaultPropertyTrialCount(),ParametersOfSameParameterizedTypeWithOneConstant.iterations);//RW
ParametersOfSameParameterizedTypeWithOneConstant.iterations=0;//RW
}