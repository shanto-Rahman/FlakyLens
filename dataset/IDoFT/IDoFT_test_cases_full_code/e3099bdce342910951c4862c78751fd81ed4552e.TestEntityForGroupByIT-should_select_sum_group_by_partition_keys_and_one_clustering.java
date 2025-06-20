@Test public void should_select_sum_group_by_partition_keys_and_one_clustering() throws Exception {
  final Long id=RandomUtils.nextLong(0L,Long.MAX_VALUE);
  scriptExecutor.executeScriptTemplate("EntityForGroupBy/insert_multi_partitions.cql",ImmutableMap.of("id",id));
  final List<TypedMap> typedMaps=manager.dsl().select().id().uuid().clust1().function(SystemFunctions.sum(COLUMNS.VAL),"sum_val").fromBaseTable().groupBy().id_uuid_clust1().getTypedMaps();
  assertThat(typedMaps).hasSize(6);
  final TypedMap row1=typedMaps.get(0);
  if (row1.<UUID>getTyped("uuID").equals(new UUID(1L,0L))) {
    assertThat(row1.<Integer>getTyped("clust1")).isEqualTo(1);
    assertThat(row1.<Integer>getTyped("sum_val")).isEqualTo(3);
    final TypedMap row2=typedMaps.get(1);
    assertThat(row2.<Integer>getTyped("clust1")).isEqualTo(2);
    assertThat(row2.<Integer>getTyped("sum_val")).isEqualTo(2);
    final TypedMap row3=typedMaps.get(2);
    assertThat(row3.<Integer>getTyped("clust1")).isEqualTo(3);
    assertThat(row3.<Integer>getTyped("sum_val")).isEqualTo(1);
    final TypedMap row4=typedMaps.get(3);
    assertThat(row4.<Integer>getTyped("clust1")).isEqualTo(1);
    assertThat(row4.<Integer>getTyped("sum_val")).isEqualTo(2);
    final TypedMap row5=typedMaps.get(4);
    assertThat(row5.<Integer>getTyped("clust1")).isEqualTo(2);
    assertThat(row5.<Integer>getTyped("sum_val")).isEqualTo(2);
    final TypedMap row6=typedMaps.get(5);
    assertThat(row6.<Integer>getTyped("clust1")).isEqualTo(3);
    assertThat(row6.<Integer>getTyped("sum_val")).isEqualTo(1);
  }
 else {
    assertThat(row1.<Integer>getTyped("clust1")).isEqualTo(1);
    assertThat(row1.<Integer>getTyped("sum_val")).isEqualTo(2);
    final TypedMap row2=typedMaps.get(1);
    assertThat(row2.<Integer>getTyped("clust1")).isEqualTo(2);
    assertThat(row2.<Integer>getTyped("sum_val")).isEqualTo(2);
    final TypedMap row3=typedMaps.get(2);
    assertThat(row3.<Integer>getTyped("clust1")).isEqualTo(3);
    assertThat(row3.<Integer>getTyped("sum_val")).isEqualTo(1);
    final TypedMap row4=typedMaps.get(3);
    assertThat(row4.<Integer>getTyped("clust1")).isEqualTo(1);
    assertThat(row4.<Integer>getTyped("sum_val")).isEqualTo(3);
    final TypedMap row5=typedMaps.get(4);
    assertThat(row5.<Integer>getTyped("clust1")).isEqualTo(2);
    assertThat(row5.<Integer>getTyped("sum_val")).isEqualTo(2);
    final TypedMap row6=typedMaps.get(5);
    assertThat(row6.<Integer>getTyped("clust1")).isEqualTo(3);
    assertThat(row6.<Integer>getTyped("sum_val")).isEqualTo(1);
  }
}
