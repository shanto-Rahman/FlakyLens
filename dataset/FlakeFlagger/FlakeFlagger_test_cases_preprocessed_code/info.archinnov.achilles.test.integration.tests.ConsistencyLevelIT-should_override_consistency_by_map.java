@Test public void should_override_consistency_by_map() throws Exception {
assertThat(pm.find(EntityWithTwoConsistency.class,entity.getId())).isNotNull();
}