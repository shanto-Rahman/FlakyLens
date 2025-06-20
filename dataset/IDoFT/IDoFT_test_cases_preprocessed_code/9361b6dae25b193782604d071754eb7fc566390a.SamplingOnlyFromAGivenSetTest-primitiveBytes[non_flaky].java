@Test public void primitiveBytes() throws Exception {
assertThat(testResult(PrimitiveBytes.class),isSuccessful());
assertEquals(defaultPropertyTrialCount(),PrimitiveBytes.iterations);//RW
PrimitiveBytes.iterations=0;//RW
}