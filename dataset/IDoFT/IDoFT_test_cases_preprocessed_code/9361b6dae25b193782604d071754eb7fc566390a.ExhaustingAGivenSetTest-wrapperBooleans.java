@Test public void wrapperBooleans() throws Exception {
assertThat(testResult(WrapperBooleans.class),isSuccessful());
assertEquals(1,WrapperBooleans.iterations);//RW
assertEquals(singleton(false),WrapperBooleans.testCases);
}