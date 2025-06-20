@Test public void enums() throws Exception {
assertThat(testResult(Enums.class),isSuccessful());
assertEquals(defaultPropertyTrialCount(),Enums.iterations);//RW
Enums.iterations=0;//RW
}