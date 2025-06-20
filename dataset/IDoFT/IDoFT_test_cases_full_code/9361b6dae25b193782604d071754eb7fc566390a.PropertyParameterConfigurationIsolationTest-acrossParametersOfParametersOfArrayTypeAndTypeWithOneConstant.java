@Test public void acrossParametersOfParametersOfArrayTypeAndTypeWithOneConstant() throws Exception {
  assertThat(testResult(ParametersOfParametersOfArrayTypeAndTypeWithOneConstant.class),isSuccessful());
  assertEquals(defaultPropertyTrialCount(),ParametersOfParametersOfArrayTypeAndTypeWithOneConstant.iterations);
}
