@Test public void primitiveShorts(){
  assertThat(testResult(PrimitiveShorts.class),isSuccessful());
  assertEquals(2,PrimitiveShorts.iterations);
  assertEquals(new HashSet<>(asList(Short.valueOf("9"),Short.valueOf("8"))),PrimitiveShorts.testCases);
  PrimitiveShorts.iterations=0;
  PrimitiveShorts.testCases.clear();
}
