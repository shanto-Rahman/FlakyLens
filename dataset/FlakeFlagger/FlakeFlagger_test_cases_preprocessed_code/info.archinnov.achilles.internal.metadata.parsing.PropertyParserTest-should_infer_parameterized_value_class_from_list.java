@SuppressWarnings("rawtypes") @Test public void should_infer_parameterized_value_class_from_list() throws Exception {
assertThat(infered).isEqualTo(Class.class);
}