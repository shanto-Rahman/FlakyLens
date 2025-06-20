@Test public void assertFindLatestJobRegisterStatistics(){
assertThat(po.get().getRegisteredCount(),is(200));
}