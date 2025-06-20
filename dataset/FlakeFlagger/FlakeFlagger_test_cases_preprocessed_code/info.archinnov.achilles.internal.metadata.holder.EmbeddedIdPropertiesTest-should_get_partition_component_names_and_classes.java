@Test public void should_get_partition_component_names_and_classes() throws Exception {
assertThat(props.getPartitionComponentNames()).containsExactly("id","type");
assertThat(props.getPartitionComponentClasses()).containsExactly(Long.class,String.class);
assertThat(props.isCompositePartitionKey()).isTrue();
}