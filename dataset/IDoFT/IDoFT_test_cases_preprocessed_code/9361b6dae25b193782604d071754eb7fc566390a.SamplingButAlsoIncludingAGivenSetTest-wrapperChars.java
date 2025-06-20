@Test public void wrapperChars() throws Exception {
assertThat(testResult(WrapperChars.class),isSuccessful());
assertEquals(defaultPropertyTrialCount(),WrapperChars.iterations);//RW
assertEquals(new HashSet<>(asList('@','#')),new HashSet<>(WrapperChars.values.subList(0,2)));
}