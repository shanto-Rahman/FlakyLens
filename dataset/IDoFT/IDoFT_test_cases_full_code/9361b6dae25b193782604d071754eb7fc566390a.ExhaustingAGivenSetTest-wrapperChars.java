@Test public void wrapperChars() throws Exception {
  assertThat(testResult(WrapperChars.class),isSuccessful());
  assertEquals(2,WrapperChars.iterations);
  assertEquals(new HashSet<>(asList('@','#')),WrapperChars.testCases);
}
