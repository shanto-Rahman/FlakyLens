@Test public void strings() throws Exception {
assertThat(testResult(Strings.class),isSuccessful());
assertEquals(defaultPropertyTrialCount(),Strings.iterations);//RW
Strings.iterations=0;//RW
}