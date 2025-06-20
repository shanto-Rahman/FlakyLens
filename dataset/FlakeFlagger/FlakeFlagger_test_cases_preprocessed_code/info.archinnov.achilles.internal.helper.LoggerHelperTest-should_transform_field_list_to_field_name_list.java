@Test public void should_transform_field_list_to_field_name_list() throws Exception {
assertThat(Lists.transform(fields,LoggerHelper.fieldToStringFn)).contains("id");
}