@Test public void explicitConversion() throws Exception {
  assertThat(testResult(ExplicitConversion.class),isSuccessful());
  assertEquals(defaultPropertyTrialCount(),ExplicitConversion.iterations);
  assertEquals(new HashSet<>(asList(LocalDate.of(2017,1,1),LocalDate.of(2001,12,25))),new HashSet<>(ExplicitConversion.values.subList(0,2)));
  ExplicitConversion.iterations=0;
}
