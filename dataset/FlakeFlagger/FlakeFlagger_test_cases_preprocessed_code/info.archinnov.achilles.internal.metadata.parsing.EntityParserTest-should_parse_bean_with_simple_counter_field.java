@Test public void should_parse_bean_with_simple_counter_field() throws Exception {
assertThat(meta).isNotNull();
assertThat(entityContext.hasSimpleCounter()).isTrue();
assertThat(idMeta).isNotNull();
assertThat(counterMeta).isNotNull();
assertThat(counterProperties).isNotNull();
assertThat(counterProperties.getFqcn()).isEqualTo(BeanWithSimpleCounter.class.getCanonicalName());
assertThat(counterProperties.getIdMeta()).isSameAs(idMeta);
}