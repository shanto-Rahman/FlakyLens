@Test public void wrapperLongs() throws Exception {
assertThat(testResult(WrapperLongs.class),isSuccessful());
assertEquals(defaultPropertyTrialCount(),WrapperLongs.iterations);//RW
assertEquals(new HashSet<>(asList(10L,11L,12L)),new HashSet<>(WrapperLongs.values.subList(0,3)));
WrapperLongs.iterations=0;//RW
}