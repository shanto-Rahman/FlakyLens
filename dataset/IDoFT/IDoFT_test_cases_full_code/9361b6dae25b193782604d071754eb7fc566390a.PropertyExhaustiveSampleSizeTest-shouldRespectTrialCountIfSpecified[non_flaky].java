@Test public void shouldRespectTrialCountIfSpecified(){
  assertThat(testResult(ForSpecifiedNumberOfValues.class),isSuccessful());
  assertEquals(5,ForSpecifiedNumberOfValues.iterations);
  ForSpecifiedNumberOfValues.iterations=0;
}
