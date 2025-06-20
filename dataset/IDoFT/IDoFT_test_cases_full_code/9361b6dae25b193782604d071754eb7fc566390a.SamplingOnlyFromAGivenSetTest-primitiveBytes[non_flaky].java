@Test public void primitiveBytes() throws Exception {
  assertThat(testResult(PrimitiveBytes.class),isSuccessful());
  assertEquals(defaultPropertyTrialCount(),PrimitiveBytes.iterations);
  PrimitiveBytes.iterations=0;
}
