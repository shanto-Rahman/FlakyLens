@Test public void wrapperDoubles() throws Exception {
  assertThat(testResult(WrapperDoubles.class),isSuccessful());
  assertEquals(2,WrapperDoubles.iterations);
  assertEquals(new HashSet<>(asList(2.7,-3.14)),WrapperDoubles.testCases);
}
