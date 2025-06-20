@Test public void shouldFeedADefaultNumberOfValuesToAProperty() throws Exception {
assertThat(testResult(ForDefaultNumberOfValues.class),isSuccessful());
assertEquals(defaultPropertyTrialCount(),ForDefaultNumberOfValues.iterations);//RW
ForDefaultNumberOfValues.iterations=0;//RW
}