@Test public void should_alter_column_type() throws Exception {
assertThat(built).isEqualTo("\n\tALTER TABLE test ALTER name TYPE ascii");
}