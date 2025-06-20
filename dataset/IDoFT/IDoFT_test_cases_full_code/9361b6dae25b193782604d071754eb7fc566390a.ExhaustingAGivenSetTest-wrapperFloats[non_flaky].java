@Test public void wrapperFloats(){
  assertThat(testResult(WrapperFloats.class),isSuccessful());
  assertEquals(2,WrapperFloats.iterations);
  assertEquals(new HashSet<>(asList(1.7F,-4.14F)),WrapperFloats.testCases);
  WrapperFloats.iterations=0;
}
