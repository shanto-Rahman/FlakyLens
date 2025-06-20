@Test public void primitiveDoubles() throws Exception {
assertThat(testResult(PrimitiveDoubles.class),isSuccessful());
assertEquals(defaultPropertyTrialCount(),PrimitiveDoubles.iterations);//RW
PrimitiveDoubles.iterations=0;//RW
}