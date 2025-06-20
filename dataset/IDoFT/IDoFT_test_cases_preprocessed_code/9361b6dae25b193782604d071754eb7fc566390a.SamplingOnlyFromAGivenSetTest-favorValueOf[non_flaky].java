@Test public void favorValueOf() throws Exception {
assertThat(testResult(FavorValueOf.class),isSuccessful());
assertEquals(defaultPropertyTrialCount(),FavorValueOf.iterations);//RW
FavorValueOf.iterations=0;//RW
}