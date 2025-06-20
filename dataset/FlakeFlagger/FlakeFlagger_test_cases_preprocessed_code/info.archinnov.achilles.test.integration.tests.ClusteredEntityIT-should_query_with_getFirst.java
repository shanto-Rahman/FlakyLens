@Test public void should_query_with_getFirst() throws Exception {
assertThat(entity).isNull();
assertThat(entity.getValue()).isEqualTo(clusteredValuePrefix + 1);
assertThat(entity.getValue()).isEqualTo(clusteredValuePrefix + 1);
assertThat(entities).hasSize(3);
assertThat(entities.get(0).getValue()).isEqualTo(clusteredValuePrefix + 1);
assertThat(entities.get(1).getValue()).isEqualTo(clusteredValuePrefix + 2);
assertThat(entities.get(2).getValue()).isEqualTo(clusteredValuePrefix + 3);
insertClusteredEntity(partitionKey,4,"name41",clusteredValuePrefix + 41);//ET
insertClusteredEntity(partitionKey,4,"name42",clusteredValuePrefix + 42);//ET
assertThat(entities).hasSize(2);
assertThat(entities.get(0).getValue()).isEqualTo(clusteredValuePrefix + 41);
assertThat(entities.get(1).getValue()).isEqualTo(clusteredValuePrefix + 42);
}