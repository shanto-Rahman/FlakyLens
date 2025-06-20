@Test public void wrapperBytes() throws Exception {
  assertThat(testResult(WrapperBytes.class),isSuccessful());
  assertEquals(defaultPropertyTrialCount(),WrapperBytes.iterations);
  assertEquals(new HashSet<>(asList((byte)14,(byte)-15)),new HashSet<>(WrapperBytes.values.subList(0,2)));
  WrapperBytes.iterations=0;
}
