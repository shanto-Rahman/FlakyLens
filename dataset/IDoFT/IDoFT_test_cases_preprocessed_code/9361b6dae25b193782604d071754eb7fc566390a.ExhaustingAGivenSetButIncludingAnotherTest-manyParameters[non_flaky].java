@Test public void manyParameters(){
assertThat(testResult(ManyParameters.class),isSuccessful());
assertEquals(16,ManyParameters.iterations);//RW
assertEquals(asList(-4,-2,-1),ManyParameters.firstTestCases.subList(0,3));
assertEquals(asList(-4,-2,-1),ManyParameters.firstTestCases.subList(4,7));
assertEquals(asList(-4,-2,-1),ManyParameters.firstTestCases.subList(8,11));
assertEquals(asList(-4,-2,-1),ManyParameters.firstTestCases.subList(12,15));
assertEquals(asList('r','r','r','r','y','y','y','y'),ManyParameters.secondTestCases.subList(0,8));
ManyParameters.iterations=0;//RW
}