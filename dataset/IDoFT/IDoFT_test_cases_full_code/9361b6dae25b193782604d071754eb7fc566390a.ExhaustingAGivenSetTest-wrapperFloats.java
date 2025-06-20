@Test public void wrapperFloats() throws Exception {
  assertThat(testResult(WrapperFloats.class),isSuccessful());
  assertEquals(2,WrapperFloats.iterations);
  assertEquals(new HashSet<>(asList(1.7F,-4.14F)),WrapperFloats.testCases);
}
