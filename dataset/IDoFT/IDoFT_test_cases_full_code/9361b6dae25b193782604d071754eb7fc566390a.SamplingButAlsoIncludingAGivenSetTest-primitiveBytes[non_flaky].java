@Test public void primitiveBytes() throws Exception {
  assertThat(testResult(PrimitiveBytes.class),isSuccessful());
  assertEquals(defaultPropertyTrialCount(),PrimitiveBytes.iterations);
  assertEquals(new HashSet<>(asList((byte)12,(byte)-13)),new HashSet<>(PrimitiveBytes.values.subList(0,2)));
  PrimitiveBytes.iterations=0;
}
