@Test public void acrossParametersOfSameArrayType() throws Exception {
  assertThat(testResult(ParametersOfSameArrayType.class),isSuccessful());
  assertEquals(defaultPropertyTrialCount(),ParametersOfSameArrayType.iterations);
  ParametersOfSameArrayType.iterations=0;
}
