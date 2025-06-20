@Test public void primitiveDoubles() throws Exception {
assertThat(testResult(PrimitiveDoubles.class),isSuccessful());
assertEquals(defaultPropertyTrialCount(),PrimitiveDoubles.iterations);//RW
}