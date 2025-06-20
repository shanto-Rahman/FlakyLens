@Test public void primitiveBooleans() throws Exception {
assertThat(testResult(PrimitiveBooleans.class),isSuccessful());
assertEquals(defaultPropertyTrialCount(),PrimitiveBooleans.iterations);//RW
assertEquals(singletonList(true),PrimitiveBooleans.values.subList(0,1));
}