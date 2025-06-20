@Test public void should_select_sum_group_by_partition_keys() throws Exception {
assertThat(typedMaps).hasSize(2);
if (row1.<UUID>getTyped("uuID").equals(new UUID(1L,0L))) {
assertThat(row1.<Integer>getTyped("sum_val")).isEqualTo(6);
assertThat(row1.<Integer>getTyped("sum_val")).isEqualTo(5);
}
if (row2.<UUID>getTyped("uuID").equals(new UUID(1L,0L))) {
assertThat(row2.<Integer>getTyped("sum_val")).isEqualTo(6);
assertThat(row2.<Integer>getTyped("sum_val")).isEqualTo(5);
}
}