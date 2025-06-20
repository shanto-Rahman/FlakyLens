@Test public void should_transform_class_list_to_canonical_class_name_list() throws Exception {
assertThat(Lists.transform(classes,LoggerHelper.fqcnToStringFn)).contains(Long.class.getCanonicalName());
}