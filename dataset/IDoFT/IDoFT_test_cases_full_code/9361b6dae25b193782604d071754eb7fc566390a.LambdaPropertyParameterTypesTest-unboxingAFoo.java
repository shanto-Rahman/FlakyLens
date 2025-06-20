@Test public void unboxingAFoo() throws Exception {
  assertThat(testResult(UnboxingAFoo.class),isSuccessful());
  assertEquals(defaultPropertyTrialCount(),UnboxingAFoo.iterations);
}
