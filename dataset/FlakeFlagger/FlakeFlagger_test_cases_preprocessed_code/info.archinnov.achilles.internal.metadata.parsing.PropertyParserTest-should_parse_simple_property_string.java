@SuppressWarnings("unchecked") @Test public void should_parse_simple_property_string() throws Exception {
assertThat(meta.getPropertyName()).isEqualTo("name");
assertThat(meta.<String>getValueClass()).isEqualTo(String.class);
assertThat(meta.getGetter().getName()).isEqualTo("getName");
assertThat((Class<String>)meta.getGetter().getReturnType()).isEqualTo(String.class);
assertThat(meta.getSetter().getName()).isEqualTo("setName");
assertThat((Class<String>)meta.getSetter().getParameterTypes()[0]).isEqualTo(String.class);
assertThat(meta.type()).isEqualTo(PropertyType.SIMPLE);
assertThat(context.getPropertyMetas().get("name")).isSameAs(meta);
}