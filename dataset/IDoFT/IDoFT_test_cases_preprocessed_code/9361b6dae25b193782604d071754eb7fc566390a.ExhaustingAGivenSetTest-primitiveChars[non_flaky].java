@Test public void primitiveChars(){
assertThat(testResult(PrimitiveChars.class),isSuccessful());
assertEquals(2,PrimitiveChars.iterations);//RW
assertEquals(new HashSet<>(asList('Z','z')),PrimitiveChars.testCases);
PrimitiveChars.iterations=0;//RW
}