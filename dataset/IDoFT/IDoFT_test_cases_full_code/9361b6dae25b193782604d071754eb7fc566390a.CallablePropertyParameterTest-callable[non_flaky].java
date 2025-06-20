@Test public void callable() throws Exception {
  assertThat(testResult(CallableOfInt.class),isSuccessful());
  assertEquals(defaultPropertyTrialCount(),CallableOfInt.iterations);
  CallableOfInt.iterations=0;
}
