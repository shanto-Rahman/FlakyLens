@Test public void booleansUnmarked(){
  assertThat(testResult(UnmarkedBooleans.class),isSuccessful());
  assertEquals(2,UnmarkedBooleans.iterations);
  assertEquals(new HashSet<>(asList(true,false)),UnmarkedBooleans.testCases);
  UnmarkedBooleans.iterations=0;
}
