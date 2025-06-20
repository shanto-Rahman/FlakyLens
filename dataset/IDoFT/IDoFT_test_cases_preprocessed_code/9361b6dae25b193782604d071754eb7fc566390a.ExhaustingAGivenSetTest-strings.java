@Test public void strings() throws Exception {
assertThat(testResult(Strings.class),isSuccessful());
assertEquals(2,Strings.iterations);//RW
assertEquals(new HashSet<>(asList("some","values")),Strings.testCases);
}