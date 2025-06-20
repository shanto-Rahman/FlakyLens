@SuppressWarnings({"rawtypes","unchecked"}) @Test public void should_parse_map_with_parameterized_value() throws Exception {
assertThat(meta.getPropertyName()).isEqualTo("map");
assertThat((Class)meta.getValueClass()).isEqualTo(List.class);
assertThat(meta.type()).isEqualTo(PropertyType.MAP);
assertThat(meta.<Integer>getKeyClass()).isEqualTo(Integer.class);
assertThat(meta.getGetter().getName()).isEqualTo("getMap");
assertThat((Class<Map>)meta.getGetter().getReturnType()).isEqualTo(Map.class);
assertThat(meta.getSetter().getName()).isEqualTo("setMap");
assertThat((Class<Map>)meta.getSetter().getParameterTypes()[0]).isEqualTo(Map.class);
}