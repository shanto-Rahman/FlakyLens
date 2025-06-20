@Test public void wrapperIntegers(){
  assertThat(testResult(WrapperIntegers.class),isSuccessful());
  assertEquals(2,WrapperIntegers.iterations);
  assertEquals(new HashSet<>(asList(4,5)),WrapperIntegers.testCases);
  WrapperIntegers.iterations=0;
  WrapperIntegers.testCases.clear();
}
