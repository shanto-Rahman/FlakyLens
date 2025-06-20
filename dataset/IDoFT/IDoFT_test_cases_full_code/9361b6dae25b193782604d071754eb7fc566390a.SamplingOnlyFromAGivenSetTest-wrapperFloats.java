@Test public void wrapperFloats() throws Exception {
  assertThat(testResult(WrapperFloats.class),isSuccessful());
  assertEquals(defaultPropertyTrialCount(),WrapperFloats.iterations);
}
