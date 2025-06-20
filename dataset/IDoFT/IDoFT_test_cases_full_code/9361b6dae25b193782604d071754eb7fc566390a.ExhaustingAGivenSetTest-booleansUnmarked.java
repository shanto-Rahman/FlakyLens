@Test public void booleansUnmarked() throws Exception {
  assertThat(testResult(UnmarkedBooleans.class),isSuccessful());
  assertEquals(2,UnmarkedBooleans.iterations);
  assertEquals(new HashSet<>(asList(true,false)),UnmarkedBooleans.testCases);
}
