@Test public void should_parse_embedded_id_with_reversed_key() throws Exception {
assertThat(props.getComponentGetters()).containsExactly(nameGetter,rankGetter,countGetter);
assertThat(props.getComponentSetters()).containsExactly(nameSetter,rankSetter,countSetter);
assertThat(props.getComponentClasses()).containsExactly(String.class,int.class,int.class);
assertThat(props.getComponentNames()).containsExactly("name","rank","count");
assertThat(props.getOrderingComponent()).isEqualTo("rank");
assertThat(props.getClusteringComponentNames()).containsExactly("rank","count");
assertThat(props.getClusteringComponentClasses()).containsExactly(int.class,int.class);
assertThat(props.getPartitionComponentNames()).containsExactly("name");
assertThat(props.getPartitionComponentClasses()).containsExactly(String.class);
assertThat(props.getCluseringOrders().get(0).getSorting()).isEqualTo(DESC);
assertThat(props.getCluseringOrders().get(1).getSorting()).isEqualTo(DESC);
}