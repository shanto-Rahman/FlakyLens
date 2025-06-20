@Test public void enums() throws Exception {
assertThat(testResult(Enums.class),isSuccessful());
assertEquals(defaultPropertyTrialCount(),Enums.iterations);//RW
assertEquals(EnumSet.of(HALF_UP,HALF_EVEN),new HashSet<>(Enums.values.subList(0,2)));
Enums.iterations=0;//RW
}