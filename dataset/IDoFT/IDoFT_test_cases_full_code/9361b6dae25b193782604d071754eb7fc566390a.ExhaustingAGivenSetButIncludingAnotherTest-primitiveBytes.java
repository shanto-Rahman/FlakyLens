@Test public void primitiveBytes() throws Exception {
  assertThat(testResult(PrimitiveBytes.class),isSuccessful());
  assertEquals(defaultPropertyTrialCount(),PrimitiveBytes.iterations);
  assertEquals(new HashSet<>(asList(Byte.valueOf("12"),Byte.valueOf("-13"))),new HashSet<>(PrimitiveBytes.values.subList(0,2)));
}
