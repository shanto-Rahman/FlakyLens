@Test public void primitiveShorts() throws Exception {
  assertThat(testResult(PrimitiveShorts.class),isSuccessful());
  assertEquals(defaultPropertyTrialCount(),PrimitiveShorts.iterations);
  PrimitiveShorts.iterations=0;
}
