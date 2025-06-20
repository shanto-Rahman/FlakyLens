@Test public void primitiveFloats() throws Exception {
  assertThat(testResult(PrimitiveFloats.class),isSuccessful());
  assertEquals(defaultPropertyTrialCount(),PrimitiveFloats.iterations);
  assertEquals(new HashSet<>(asList(3.3F,-5F)),new HashSet<>(PrimitiveFloats.values.subList(0,2)));
  PrimitiveFloats.iterations=0;
}
