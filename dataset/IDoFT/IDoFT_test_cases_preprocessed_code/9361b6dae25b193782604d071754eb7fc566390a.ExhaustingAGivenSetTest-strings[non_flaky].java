@Test public void strings(){
assertThat(testResult(Strings.class),isSuccessful());
assertEquals(2,Strings.iterations);//RW
assertEquals(new HashSet<>(asList("some","values")),Strings.testCases);
Strings.iterations=0;//RW
}