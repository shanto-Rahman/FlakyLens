@Test public void primitiveBooleans() throws Exception {
  assertThat(testResult(PrimitiveBooleans.class),isSuccessful());
  assertEquals(defaultPropertyTrialCount(),PrimitiveBooleans.iterations);
  assertEquals(singletonList(true),PrimitiveBooleans.values.subList(0,1));
  PrimitiveBooleans.iterations=0;
}
