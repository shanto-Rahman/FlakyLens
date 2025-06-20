@SuppressWarnings({"rawtypes","unchecked"}) @Test public void should_parse_list() throws Exception {
assertThat(meta.getPropertyName()).isEqualTo("friends");
assertThat(meta.<String>getValueClass()).isEqualTo(String.class);
assertThat(meta.getGetter().getName()).isEqualTo("getFriends");
assertThat((Class<List>)meta.getGetter().getReturnType()).isEqualTo(List.class);
assertThat(meta.getSetter().getName()).isEqualTo("setFriends");
assertThat((Class<List>)meta.getSetter().getParameterTypes()[0]).isEqualTo(List.class);
assertThat(meta.type()).isEqualTo(PropertyType.LIST);
assertThat(meta.nullValueForCollectionAndMap()).isNotNull().isInstanceOf(List.class);
assertThat(meta2.type()).isEqualTo(PropertyType.LIST);
assertThat(meta2.nullValueForCollectionAndMap()).isNotNull().isInstanceOf(List.class);
}