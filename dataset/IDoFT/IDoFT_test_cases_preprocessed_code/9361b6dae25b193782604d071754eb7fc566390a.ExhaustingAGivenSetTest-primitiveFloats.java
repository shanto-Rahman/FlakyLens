@Test public void primitiveFloats() throws Exception {
assertThat(testResult(PrimitiveFloats.class),isSuccessful());
assertEquals(2,PrimitiveFloats.iterations);//RW
assertEquals(new HashSet<>(asList(3.3F,-5F)),PrimitiveFloats.testCases);
}