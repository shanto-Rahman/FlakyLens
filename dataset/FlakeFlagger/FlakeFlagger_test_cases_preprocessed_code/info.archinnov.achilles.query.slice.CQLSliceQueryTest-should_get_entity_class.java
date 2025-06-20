@Test public void should_get_entity_class() throws Exception {
assertThat(cqlSliceQuery.getEntityClass()).isSameAs(ClusteredEntity.class);
}