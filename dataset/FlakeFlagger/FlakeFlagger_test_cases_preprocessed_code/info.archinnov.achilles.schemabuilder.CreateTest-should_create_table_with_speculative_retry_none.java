@Test public void should_create_table_with_speculative_retry_none() throws Exception {
assertThat(built).isEqualTo("\n\tCREATE TABLE test(\n\t\t" + "id bigint,\n\t\t" + "name text,\n\t\t"+ "PRIMARY KEY(id))\n\t"+ "WITH speculative_retry = 'NONE'");
}