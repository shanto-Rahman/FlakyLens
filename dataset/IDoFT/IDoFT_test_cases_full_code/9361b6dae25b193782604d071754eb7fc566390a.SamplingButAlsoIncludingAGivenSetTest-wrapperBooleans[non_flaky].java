@Test public void wrapperBooleans() throws Exception {
  assertThat(testResult(WrapperBooleans.class),isSuccessful());
  assertEquals(defaultPropertyTrialCount(),WrapperBooleans.iterations);
  assertEquals(false,WrapperBooleans.values.get(0));
  assertEquals(new HashSet<>(asList(true,false)),new HashSet<>(WrapperBooleans.values));
  WrapperBooleans.iterations=0;
}
