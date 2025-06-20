@Test public void primitiveFloats() throws Exception {
assertThat(testResult(PrimitiveFloats.class),isSuccessful());
assertEquals(defaultPropertyTrialCount(),PrimitiveFloats.iterations);//RW
PrimitiveFloats.iterations=0;//RW
}