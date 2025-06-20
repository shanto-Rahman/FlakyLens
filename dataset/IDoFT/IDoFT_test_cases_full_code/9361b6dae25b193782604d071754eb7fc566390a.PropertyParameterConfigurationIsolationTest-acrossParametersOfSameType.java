@Test public void acrossParametersOfSameType() throws Exception {
  assertThat(testResult(ParametersOfSameType.class),isSuccessful());
  assertEquals(defaultPropertyTrialCount(),ParametersOfSameType.iterations);
}
