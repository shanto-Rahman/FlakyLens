@Test public void explicitGeneratorTakesPrecedence(){
assertThat(testResult(WithExplicitGenerator.class),isSuccessful());
assertEquals(asList(0,1,2,3,4),WithExplicitGenerator.values);
}