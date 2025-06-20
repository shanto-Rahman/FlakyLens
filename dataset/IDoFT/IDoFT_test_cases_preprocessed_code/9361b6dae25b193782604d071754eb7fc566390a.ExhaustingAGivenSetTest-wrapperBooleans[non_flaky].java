@Test public void wrapperBooleans(){
assertThat(testResult(WrapperBooleans.class),isSuccessful());
assertEquals(1,WrapperBooleans.iterations);//RW
assertEquals(singleton(false),WrapperBooleans.testCases);
WrapperBooleans.iterations=0;//RW
}