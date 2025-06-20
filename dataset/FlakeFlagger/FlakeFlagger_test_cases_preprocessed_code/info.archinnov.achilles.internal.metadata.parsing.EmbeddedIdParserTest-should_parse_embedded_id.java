@Test public void should_parse_embedded_id() throws Exception {
assertThat(props.getComponentGetters()).containsExactly(nameGetter,rankGetter);
assertThat(props.getComponentSetters()).containsExactly(nameSetter,rankSetter);
assertThat(props.getComponentClasses()).containsExactly(String.class,int.class);
assertThat(props.getComponentNames()).containsExactly("name","rank");
assertThat(props.getOrderingComponent()).isEqualTo("rank");
assertThat(props.getClusteringComponentNames()).containsExactly("rank");
assertThat(props.getClusteringComponentClasses()).containsExactly(int.class);
assertThat(props.getPartitionComponentNames()).containsExactly("name");
assertThat(props.getPartitionComponentClasses()).containsExactly(String.class);
}