@Test public void wrapperLongs() throws Exception {
  assertThat(testResult(WrapperLongs.class),isSuccessful());
  assertEquals(defaultPropertyTrialCount(),WrapperLongs.iterations);
}
