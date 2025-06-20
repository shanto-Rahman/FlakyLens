@Test public void favorValueOf(){
assertThat(testResult(FavorValueOf.class),isSuccessful());
assertEquals(2,FavorValueOf.iterations);//RW
assertEquals(new HashSet<>(asList(FavorValueOf.Target.valueOf("a"),FavorValueOf.Target.valueOf("b"))),FavorValueOf.testCases);//IT
FavorValueOf.iterations=0;//RW
}