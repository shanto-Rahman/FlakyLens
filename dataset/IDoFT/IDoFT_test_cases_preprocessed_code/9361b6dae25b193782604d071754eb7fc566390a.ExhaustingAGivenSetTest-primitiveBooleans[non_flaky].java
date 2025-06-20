@Test public void primitiveBooleans(){
assertThat(testResult(PrimitiveBooleans.class),isSuccessful());
assertEquals(1,PrimitiveBooleans.iterations);//RW
assertEquals(singleton(true),PrimitiveBooleans.testCases);
PrimitiveBooleans.iterations=0;//RW
}