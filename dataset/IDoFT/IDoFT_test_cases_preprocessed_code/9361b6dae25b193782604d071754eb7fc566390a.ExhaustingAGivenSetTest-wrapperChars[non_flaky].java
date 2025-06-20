@Test public void wrapperChars(){
assertThat(testResult(WrapperChars.class),isSuccessful());
assertEquals(2,WrapperChars.iterations);//RW
assertEquals(new HashSet<>(asList('@','#')),WrapperChars.testCases);
WrapperChars.iterations=0;//RW
}