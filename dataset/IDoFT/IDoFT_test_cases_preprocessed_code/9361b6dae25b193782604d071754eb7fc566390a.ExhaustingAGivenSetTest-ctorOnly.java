@Test public void ctorOnly() throws Exception {
assertThat(testResult(CtorOnly.class),isSuccessful());
assertEquals(2,CtorOnly.iterations);//RW
assertEquals(new HashSet<>(asList(new CtorOnly.Target("a"),new CtorOnly.Target("b"))),CtorOnly.testCases);
}