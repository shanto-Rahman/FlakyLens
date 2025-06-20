@Test public void wrapperLongs() throws Exception {
  assertThat(testResult(WrapperLongs.class),isSuccessful());
  assertEquals(defaultPropertyTrialCount(),WrapperLongs.iterations);
  assertEquals(new HashSet<>(asList(10L,11L,12L)),new HashSet<>(WrapperLongs.values.subList(0,3)));
}
