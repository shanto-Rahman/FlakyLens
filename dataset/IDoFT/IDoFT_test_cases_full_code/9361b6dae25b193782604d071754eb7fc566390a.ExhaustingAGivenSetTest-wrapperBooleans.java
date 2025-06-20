@Test public void wrapperBooleans() throws Exception {
  assertThat(testResult(WrapperBooleans.class),isSuccessful());
  assertEquals(1,WrapperBooleans.iterations);
  assertEquals(singleton(false),WrapperBooleans.testCases);
}
