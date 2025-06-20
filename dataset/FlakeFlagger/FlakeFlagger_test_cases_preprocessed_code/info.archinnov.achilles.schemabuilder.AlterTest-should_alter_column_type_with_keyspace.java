@Test public void should_alter_column_type_with_keyspace() throws Exception {
assertThat(built).isEqualTo("\n\tALTER TABLE ks.test ALTER name TYPE ascii");
}