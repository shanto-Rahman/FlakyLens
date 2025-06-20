@Test public void usesRegularTrialCount() throws Exception {
assertThat(testResult(EnumTester.class),isSuccessful());
assertEquals(defaultPropertyTrialCount(),EnumTester.iterations);//RW
EnumTester.iterations=0;//RW
}