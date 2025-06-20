@Test public void explicitConversion() throws Exception {
assertThat(testResult(ExplicitConversion.class),isSuccessful());
assertEquals(2,ExplicitConversion.iterations);//RW
assertEquals(new HashSet<>(asList(LocalDate.of(2017,1,1),LocalDate.of(2001,12,25))),ExplicitConversion.testCases);
}