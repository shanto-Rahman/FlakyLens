@Test public void should_return_null_if_no_fqcn() throws Exception {
assertThat(propertyMeta.fqcn()).isNull();
}