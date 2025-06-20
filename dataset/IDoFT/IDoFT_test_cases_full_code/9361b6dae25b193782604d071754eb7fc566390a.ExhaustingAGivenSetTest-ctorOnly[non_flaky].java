@Test public void ctorOnly(){
  assertThat(testResult(CtorOnly.class),isSuccessful());
  assertEquals(2,CtorOnly.iterations);
  assertEquals(new HashSet<>(asList(new CtorOnly.Target("a"),new CtorOnly.Target("b"))),CtorOnly.testCases);
  CtorOnly.iterations=0;
  CtorOnly.testCases.clear();
}
