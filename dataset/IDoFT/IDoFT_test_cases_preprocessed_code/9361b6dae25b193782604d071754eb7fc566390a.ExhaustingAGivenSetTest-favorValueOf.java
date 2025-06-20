@Test public void favorValueOf() throws Exception {
assertThat(testResult(FavorValueOf.class),isSuccessful());
assertEquals(2,FavorValueOf.iterations);//RW
assertEquals(new HashSet<>(asList(FavorValueOf.Target.valueOf("a"),FavorValueOf.Target.valueOf("b"))),FavorValueOf.testCases);//IT
}