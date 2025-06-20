@Test public void strings() throws Exception {
  assertThat(testResult(Strings.class),isSuccessful());
  assertEquals(defaultPropertyTrialCount(),Strings.iterations);
  Strings.iterations=0;
}
