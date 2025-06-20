@Test public void primitiveBooleans() throws Exception {
assertThat(testResult(PrimitiveBooleans.class),isSuccessful());
assertEquals(defaultPropertyTrialCount(),PrimitiveBooleans.iterations);//RW
PrimitiveBooleans.iterations=0;//RW
}