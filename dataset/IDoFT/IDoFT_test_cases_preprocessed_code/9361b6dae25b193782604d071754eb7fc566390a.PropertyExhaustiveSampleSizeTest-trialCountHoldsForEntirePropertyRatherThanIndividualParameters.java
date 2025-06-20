@Test public void trialCountHoldsForEntirePropertyRatherThanIndividualParameters(){
assertThat(testResult(ForValuesOfMultipleParameters.class),isSuccessful());
assertEquals(4,ForValuesOfMultipleParameters.iterations);//RW
assertEquals(8,foos.size());
assertEquals(foos.get(0),foos.get(4));
assertEquals(foos.get(1),foos.get(3));
assertEquals(foos.get(2),foos.get(6));
assertEquals(foos.get(5),foos.get(7));
}