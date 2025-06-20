@Test public void should_query_with_default_params() throws Exception {
assertThat(entities).isEmpty();
assertThat(entities).hasSize(3);
assertThat(entities.get(0).getValue()).isEqualTo(clusteredValuePrefix + 2);
assertThat(entities.get(0).getId().getId()).isEqualTo(partitionKey);
assertThat(entities.get(0).getId().getCount()).isEqualTo(1);
assertThat(entities.get(0).getId().getName()).isEqualTo("name2");
assertThat(entities.get(1).getValue()).isEqualTo(clusteredValuePrefix + 3);
assertThat(entities.get(1).getId().getId()).isEqualTo(partitionKey);
assertThat(entities.get(1).getId().getCount()).isEqualTo(1);
assertThat(entities.get(1).getId().getName()).isEqualTo("name3");
assertThat(entities.get(2).getValue()).isEqualTo(clusteredValuePrefix + 4);
assertThat(entities.get(2).getId().getId()).isEqualTo(partitionKey);
assertThat(entities.get(2).getId().getCount()).isEqualTo(1);
assertThat(entities.get(2).getId().getName()).isEqualTo("name4");
assertThat(entities).hasSize(3);
assertThat(entities.get(0).getValue()).isEqualTo(clusteredValuePrefix + 2);
assertThat(entities.get(0).getId().getId()).isEqualTo(partitionKey);
assertThat(entities.get(0).getId().getCount()).isEqualTo(1);
assertThat(entities.get(0).getId().getName()).isEqualTo("name2");
assertThat(entities.get(1).getValue()).isEqualTo(clusteredValuePrefix + 3);
assertThat(entities.get(1).getId().getId()).isEqualTo(partitionKey);
assertThat(entities.get(1).getId().getCount()).isEqualTo(1);
assertThat(entities.get(1).getId().getName()).isEqualTo("name3");
assertThat(entities.get(2).getValue()).isEqualTo(clusteredValuePrefix + 4);
assertThat(entities.get(2).getId().getId()).isEqualTo(partitionKey);
assertThat(entities.get(2).getId().getCount()).isEqualTo(1);
assertThat(entities.get(2).getId().getName()).isEqualTo("name4");
}