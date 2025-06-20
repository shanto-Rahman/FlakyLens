@Test public void primitiveBooleans() throws Exception {
  assertThat(testResult(PrimitiveBooleans.class),isSuccessful());
  assertEquals(defaultPropertyTrialCount(),PrimitiveBooleans.iterations);
}
