@Test public void wrapperShorts() throws Exception {
  assertThat(testResult(WrapperShorts.class),isSuccessful());
  assertEquals(2,WrapperShorts.iterations);
  assertEquals(new HashSet<>(asList(Short.valueOf("-13"),Short.valueOf("-14"))),WrapperShorts.testCases);
}
