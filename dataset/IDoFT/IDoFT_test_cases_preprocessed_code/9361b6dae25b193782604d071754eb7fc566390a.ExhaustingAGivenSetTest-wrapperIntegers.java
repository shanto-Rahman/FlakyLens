@Test public void wrapperIntegers() throws Exception {
assertThat(testResult(WrapperIntegers.class),isSuccessful());
assertEquals(2,WrapperIntegers.iterations);//RW
assertEquals(new HashSet<>(asList(4,5)),WrapperIntegers.testCases);
}