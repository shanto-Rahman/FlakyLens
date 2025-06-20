@Test public void onlyTrumpsAlso() throws Exception {
assertThat(testResult(OnlyTrumpsAlso.class),isSuccessful());
assertEquals(defaultPropertyTrialCount(),OnlyTrumpsAlso.iterations);//RW
OnlyTrumpsAlso.iterations=0;//RW
}