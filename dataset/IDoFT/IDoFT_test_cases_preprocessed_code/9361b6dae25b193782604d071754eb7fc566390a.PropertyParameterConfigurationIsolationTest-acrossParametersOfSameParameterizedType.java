@Test public void acrossParametersOfSameParameterizedType() throws Exception {
assertThat(testResult(ParametersOfSameParameterizedType.class),isSuccessful());
assertEquals(defaultPropertyTrialCount(),ParametersOfSameParameterizedType.iterations);//RW
}