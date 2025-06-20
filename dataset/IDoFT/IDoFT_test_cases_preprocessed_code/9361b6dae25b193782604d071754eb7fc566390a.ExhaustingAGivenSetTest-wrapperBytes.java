@Test public void wrapperBytes() throws Exception {
assertThat(testResult(WrapperBytes.class),isSuccessful());
assertEquals(2,WrapperBytes.iterations);//RW
assertEquals(new HashSet<>(asList(Byte.valueOf("14"),Byte.valueOf("-15"))),WrapperBytes.testCases);
}