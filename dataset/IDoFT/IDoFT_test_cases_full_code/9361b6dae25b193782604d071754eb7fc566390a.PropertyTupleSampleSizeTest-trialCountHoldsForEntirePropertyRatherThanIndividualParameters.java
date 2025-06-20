@Test public void trialCountHoldsForEntirePropertyRatherThanIndividualParameters(){
  assertThat(testResult(ForValuesOfMultipleParameters.class),isSuccessful());
  assertEquals(21,ForValuesOfMultipleParameters.iterations);
}
