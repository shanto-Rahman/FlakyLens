@Test public void primitiveIntegers() throws Exception {
assertThat(testResult(PrimitiveIntegers.class),isSuccessful());
assertEquals(defaultPropertyTrialCount(),PrimitiveIntegers.iterations);//RW
PrimitiveIntegers.iterations=0;//RW
}