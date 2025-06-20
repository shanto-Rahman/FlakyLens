@Test public void alsoHonorsGeneratorsApartFromFixedSet() throws Exception {
assertThat(testResult(AlsoHonorsGenerators.class),isSuccessful());
assertEquals(defaultPropertyTrialCount(),AlsoHonorsGenerators.iterations);//RW
assertEquals(new HashSet<>(asList(1,2,3)),new HashSet<>(AlsoHonorsGenerators.values.subList(0,3)));
assertEquals(new HashSet<>(asList(4,5)),new HashSet<>(AlsoHonorsGenerators.values.subList(3,AlsoHonorsGenerators.values.size())));
}