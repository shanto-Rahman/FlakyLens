@Test public void primitiveChars() throws Exception {
assertThat(testResult(PrimitiveChars.class),isSuccessful());
assertEquals(defaultPropertyTrialCount(),PrimitiveChars.iterations);//RW
PrimitiveChars.iterations=0;//RW
}