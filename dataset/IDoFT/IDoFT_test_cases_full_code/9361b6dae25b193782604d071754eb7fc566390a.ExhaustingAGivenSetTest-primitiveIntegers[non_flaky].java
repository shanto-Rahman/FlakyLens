@Test public void primitiveIntegers(){
  assertThat(testResult(PrimitiveIntegers.class),isSuccessful());
  assertEquals(3,PrimitiveIntegers.iterations);
  assertEquals(new HashSet<>(asList(1,2,3)),PrimitiveIntegers.testCases);
  PrimitiveIntegers.iterations=0;
  PrimitiveIntegers.testCases.clear();
}
