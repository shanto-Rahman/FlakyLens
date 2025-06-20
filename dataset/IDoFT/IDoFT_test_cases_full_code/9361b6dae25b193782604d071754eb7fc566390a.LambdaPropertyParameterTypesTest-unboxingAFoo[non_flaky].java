@Test public void unboxingAFoo() throws Exception {
  assertThat(testResult(UnboxingAFoo.class),isSuccessful());
  assertEquals(defaultPropertyTrialCount(),UnboxingAFoo.iterations);
  UnboxingAFoo.iterations=0;
}
