@Test public void enumsUnmarked() throws Exception {
  assertThat(testResult(EnumsUnmarked.class),isSuccessful());
  assertEquals(EnumSet.allOf(RoundingMode.class).size(),EnumsUnmarked.iterations);
  assertEquals(EnumSet.allOf(RoundingMode.class),EnumsUnmarked.testCases);
}
