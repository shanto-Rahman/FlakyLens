@Test public void primitiveChars() throws Exception {
assertThat(testResult(PrimitiveChars.class),isSuccessful());
assertEquals(2,PrimitiveChars.iterations);//RW
assertEquals(new HashSet<>(asList('Z','z')),PrimitiveChars.testCases);
}