@Test public void favorValueOf(){
  assertThat(testResult(FavorValueOf.class),isSuccessful());
  assertEquals(2,FavorValueOf.iterations);
  assertEquals(new HashSet<>(asList(FavorValueOf.Target.valueOf("a"),FavorValueOf.Target.valueOf("b"))),FavorValueOf.testCases);
  FavorValueOf.iterations=0;
  FavorValueOf.testCases.clear();
}
