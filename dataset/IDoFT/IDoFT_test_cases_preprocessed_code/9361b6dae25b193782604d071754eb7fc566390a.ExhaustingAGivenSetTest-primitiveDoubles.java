@Test public void primitiveDoubles() throws Exception {
assertThat(testResult(PrimitiveDoubles.class),isSuccessful());
assertEquals(2,PrimitiveDoubles.iterations);//RW
assertEquals(new HashSet<>(asList(3.2,-4D)),PrimitiveDoubles.testCases);
}