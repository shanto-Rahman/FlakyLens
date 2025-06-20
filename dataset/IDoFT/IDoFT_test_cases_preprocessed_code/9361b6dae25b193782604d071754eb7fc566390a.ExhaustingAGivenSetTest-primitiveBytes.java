@Test public void primitiveBytes() throws Exception {
assertThat(testResult(PrimitiveBytes.class),isSuccessful());
assertEquals(2,PrimitiveBytes.iterations);//RW
assertEquals(new HashSet<>(asList(Byte.valueOf("12"),Byte.valueOf("-13"))),PrimitiveBytes.testCases);
}