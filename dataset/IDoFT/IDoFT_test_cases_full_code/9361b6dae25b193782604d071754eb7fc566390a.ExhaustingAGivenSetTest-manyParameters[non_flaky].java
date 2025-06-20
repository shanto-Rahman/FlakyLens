@Test public void manyParameters(){
  assertThat(testResult(ManyParameters.class),isSuccessful());
  assertEquals(6,ManyParameters.iterations);
  assertEquals(asList(-4,-2,-1,-4,-2,-1),ManyParameters.firstTestCases);
  assertEquals(asList('r','r','r','y','y','y'),ManyParameters.secondTestCases);
  ManyParameters.iterations=0;
  ManyParameters.firstTestCases.clear();
  ManyParameters.secondTestCases.clear();
}
