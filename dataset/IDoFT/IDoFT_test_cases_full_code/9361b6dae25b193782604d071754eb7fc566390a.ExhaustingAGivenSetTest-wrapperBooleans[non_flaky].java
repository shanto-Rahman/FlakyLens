@Test public void wrapperBooleans(){
  assertThat(testResult(WrapperBooleans.class),isSuccessful());
  assertEquals(1,WrapperBooleans.iterations);
  assertEquals(singleton(false),WrapperBooleans.testCases);
  WrapperBooleans.iterations=0;
}
