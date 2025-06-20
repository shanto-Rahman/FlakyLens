@Test public void primitiveDoubles() throws Exception {
  assertThat(testResult(PrimitiveDoubles.class),isSuccessful());
  assertEquals(defaultPropertyTrialCount(),PrimitiveDoubles.iterations);
  assertEquals(new HashSet<>(asList(3.2,-4D)),new HashSet<>(PrimitiveDoubles.values.subList(0,2)));
  PrimitiveDoubles.iterations=0;
}
