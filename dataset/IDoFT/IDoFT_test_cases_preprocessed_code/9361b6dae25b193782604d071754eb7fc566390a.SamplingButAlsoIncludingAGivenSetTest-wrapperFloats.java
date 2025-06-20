@Test public void wrapperFloats() throws Exception {
assertThat(testResult(WrapperFloats.class),isSuccessful());
assertEquals(defaultPropertyTrialCount(),WrapperFloats.iterations);//RW
assertEquals(new HashSet<>(asList(1.7F,-4.14F)),new HashSet<>(WrapperFloats.values.subList(0,2)));
}