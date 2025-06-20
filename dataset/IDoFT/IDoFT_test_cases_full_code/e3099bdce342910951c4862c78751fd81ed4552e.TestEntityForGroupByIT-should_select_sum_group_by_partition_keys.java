@Test public void should_select_sum_group_by_partition_keys() throws Exception {
  final Long id=RandomUtils.nextLong(0L,Long.MAX_VALUE);
  scriptExecutor.executeScriptTemplate("EntityForGroupBy/insert_multi_partitions.cql",ImmutableMap.of("id",id));
  final List<TypedMap> typedMaps=manager.dsl().select().id().uuid().function(SystemFunctions.sum(COLUMNS.VAL),"sum_val").fromBaseTable().groupBy().id_uuid().getTypedMaps();
  assertThat(typedMaps).hasSize(2);
  final TypedMap row1=typedMaps.get(0);
  if (row1.<UUID>getTyped("uuID").equals(new UUID(1L,0L))) {
    assertThat(row1.<Integer>getTyped("sum_val")).isEqualTo(6);
  }
 else {
    assertThat(row1.<Integer>getTyped("sum_val")).isEqualTo(5);
  }
  final TypedMap row2=typedMaps.get(1);
  if (row2.<UUID>getTyped("uuID").equals(new UUID(1L,0L))) {
    assertThat(row2.<Integer>getTyped("sum_val")).isEqualTo(6);
  }
 else {
    assertThat(row2.<Integer>getTyped("sum_val")).isEqualTo(5);
  }
}
