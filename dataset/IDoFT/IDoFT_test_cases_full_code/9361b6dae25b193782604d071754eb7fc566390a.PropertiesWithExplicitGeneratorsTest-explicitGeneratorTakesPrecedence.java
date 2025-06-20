@Test public void explicitGeneratorTakesPrecedence() throws Exception {
  assertThat(testResult(WithExplicitGenerator.class),isSuccessful());
  assertEquals(asList(0,1,2,3,4),WithExplicitGenerator.values);
}
