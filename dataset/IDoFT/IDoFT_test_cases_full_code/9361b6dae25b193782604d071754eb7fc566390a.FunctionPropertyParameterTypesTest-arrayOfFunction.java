@Test public void arrayOfFunction() throws Exception {
  assertThat(testResult(ArrayOfFunction.class),isSuccessful());
  assertEquals(defaultPropertyTrialCount(),SuperShortToExtendsInteger.iterations);
}
