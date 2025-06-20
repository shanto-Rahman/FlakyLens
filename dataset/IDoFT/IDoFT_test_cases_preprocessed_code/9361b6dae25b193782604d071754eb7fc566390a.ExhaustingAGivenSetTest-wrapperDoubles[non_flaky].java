@Test public void wrapperDoubles(){
assertThat(testResult(WrapperDoubles.class),isSuccessful());
assertEquals(2,WrapperDoubles.iterations);//RW
assertEquals(new HashSet<>(asList(2.7,-3.14)),WrapperDoubles.testCases);
WrapperDoubles.iterations=0;//RW
}