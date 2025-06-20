@Test public void onlyTrumpsGenerators() throws Exception {
assertThat(testResult(OnlyTrumpsGenerators.class),isSuccessful());
assertEquals(defaultPropertyTrialCount(),OnlyTrumpsGenerators.iterations);//RW
}