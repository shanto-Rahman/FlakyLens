@Test public void wrapperShorts() throws Exception {
assertThat(testResult(WrapperShorts.class),isSuccessful());
assertEquals(defaultPropertyTrialCount(),WrapperShorts.iterations);//RW
assertEquals(new HashSet<>(asList(Short.valueOf("-13"),Short.valueOf("-14"))),new HashSet<>(WrapperShorts.values.subList(0,2)));
WrapperShorts.iterations=0;//RW
}