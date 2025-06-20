@Test public void primitiveBooleans() throws Exception {
  assertThat(testResult(PrimitiveBooleans.class),isSuccessful());
  assertEquals(1,PrimitiveBooleans.iterations);
  assertEquals(singleton(true),PrimitiveBooleans.testCases);
}
