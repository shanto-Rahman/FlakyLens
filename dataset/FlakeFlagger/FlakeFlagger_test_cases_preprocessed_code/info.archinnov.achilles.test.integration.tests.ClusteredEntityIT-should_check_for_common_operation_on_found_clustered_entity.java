@Test public void should_check_for_common_operation_on_found_clustered_entity() throws Exception {
assertThat(check.getValue()).isEqualTo("dirty");
assertThat(clusteredEntity.getValue()).isEqualTo("dirty_again");
assertThat(manager.find(ClusteredEntity.class,clusteredEntity.getId())).isNull();
}