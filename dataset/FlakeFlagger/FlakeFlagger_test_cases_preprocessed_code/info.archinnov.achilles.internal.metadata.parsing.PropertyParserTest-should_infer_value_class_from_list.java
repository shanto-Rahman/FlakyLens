@Test public void should_infer_value_class_from_list() throws Exception {
assertThat(infered).isEqualTo(String.class);
}