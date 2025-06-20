@Test public void wrapperShorts() throws Exception {
  assertThat(testResult(WrapperShorts.class),isSuccessful());
  assertEquals(defaultPropertyTrialCount(),WrapperShorts.iterations);
}
