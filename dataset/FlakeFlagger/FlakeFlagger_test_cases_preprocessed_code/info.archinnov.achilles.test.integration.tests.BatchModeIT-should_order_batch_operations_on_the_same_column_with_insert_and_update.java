@Test public void should_order_batch_operations_on_the_same_column_with_insert_and_update() throws Exception {
assertThat(row.getString("label")).isEqualTo("label");
}