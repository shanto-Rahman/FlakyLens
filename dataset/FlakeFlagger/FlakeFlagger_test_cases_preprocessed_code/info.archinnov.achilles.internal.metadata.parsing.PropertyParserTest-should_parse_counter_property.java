@Test public void should_parse_counter_property() throws Exception {
assertThat(meta.type()).isEqualTo(PropertyType.COUNTER);
assertThat(meta.getCounterProperties()).isNotNull();
assertThat(meta.getCounterProperties().getFqcn()).isEqualTo(Test.class.getCanonicalName());
assertThat(context.getCounterMetas().get(0)).isSameAs(meta);
}