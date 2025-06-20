@Test public void wrapperLongs() throws Exception {
assertThat(testResult(WrapperLongs.class),isSuccessful());
assertEquals(3,WrapperLongs.iterations);//RW
assertEquals(new HashSet<>(asList(10L,11L,12L)),WrapperLongs.testCases);
}