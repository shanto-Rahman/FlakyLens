@Test public void primitiveIntegers(){
assertThat(testResult(PrimitiveIntegers.class),isSuccessful());
assertEquals(3,PrimitiveIntegers.iterations);//RW
assertEquals(new HashSet<>(asList(1,2,3)),PrimitiveIntegers.testCases);
PrimitiveIntegers.iterations=0;//RW
}