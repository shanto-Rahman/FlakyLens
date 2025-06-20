@Test public void primitiveBooleans() throws Exception {
  assertThat(testResult(PrimitiveBooleans.class),isSuccessful());
  assertEquals(defaultPropertyTrialCount(),PrimitiveBooleans.iterations);
  assertEquals(true,PrimitiveBooleans.values.get(0));
  assertEquals(new HashSet<>(asList(true,false)),new HashSet<>(PrimitiveBooleans.values));
  PrimitiveBooleans.iterations=0;
}
