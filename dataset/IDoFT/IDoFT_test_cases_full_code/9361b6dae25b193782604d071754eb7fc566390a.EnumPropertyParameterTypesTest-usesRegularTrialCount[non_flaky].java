@Test public void usesRegularTrialCount() throws Exception {
  assertThat(testResult(EnumTester.class),isSuccessful());
  assertEquals(defaultPropertyTrialCount(),EnumTester.iterations);
  EnumTester.iterations=0;
}
