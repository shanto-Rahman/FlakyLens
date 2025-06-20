@Test public void favorValueOf() throws Exception {
assertThat(testResult(FavorValueOf.class),isSuccessful());
assertEquals(defaultPropertyTrialCount(),FavorValueOf.iterations);//RW
assertEquals(new HashSet<>(asList(FavorValueOf.Target.valueOf("a"),FavorValueOf.Target.valueOf("b"))),new HashSet<>(FavorValueOf.values.subList(0,2)));//IT
FavorValueOf.iterations=0;//RW
}