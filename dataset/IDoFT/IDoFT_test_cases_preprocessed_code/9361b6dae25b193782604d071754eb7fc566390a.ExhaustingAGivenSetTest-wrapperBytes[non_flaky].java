@Test public void wrapperBytes(){
assertThat(testResult(WrapperBytes.class),isSuccessful());
assertEquals(2,WrapperBytes.iterations);//RW
assertEquals(new HashSet<>(asList(Byte.valueOf("14"),Byte.valueOf("-15"))),WrapperBytes.testCases);
WrapperBytes.iterations=0;//RW
}