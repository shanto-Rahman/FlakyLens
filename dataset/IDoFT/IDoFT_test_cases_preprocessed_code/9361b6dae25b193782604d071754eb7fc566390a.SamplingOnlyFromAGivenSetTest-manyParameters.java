@Test public void manyParameters() throws Exception {
assertThat(testResult(ManyParameters.class),isSuccessful());
assertEquals(defaultPropertyTrialCount(),ManyParameters.iterations);//RW
}