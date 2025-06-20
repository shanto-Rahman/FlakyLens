@Test public void should_iterate_with_default_params() throws Exception {
assertThat(iter.hasNext()).isTrue();
assertThat(next.getValue()).isEqualTo(clusteredValuePrefix + 1);
assertThat(next.getId().getId()).isEqualTo(partitionKey);
assertThat(next.getId().getCount()).isEqualTo(1);
assertThat(next.getId().getName()).isEqualTo("name1");
assertThat(iter.hasNext()).isTrue();
assertThat(iter.hasNext()).isTrue();
assertThat(next.getId().getId()).isEqualTo(partitionKey);
assertThat(next.getId().getCount()).isEqualTo(1);
assertThat(next.getId().getName()).isEqualTo("name2");
assertThat(next.getValue()).isEqualTo(clusteredValuePrefix + 2);
assertThat(iter.hasNext()).isTrue();
assertThat(next.getId().getId()).isEqualTo(partitionKey);
assertThat(next.getId().getCount()).isEqualTo(1);
assertThat(next.getId().getName()).isEqualTo("name3");
assertThat(next.getValue()).isEqualTo(clusteredValuePrefix + 3);
assertThat(iter.hasNext()).isTrue();
assertThat(next.getId().getId()).isEqualTo(partitionKey);
assertThat(next.getId().getCount()).isEqualTo(1);
assertThat(next.getId().getName()).isEqualTo("name4");
assertThat(next.getValue()).isEqualTo(clusteredValuePrefix + 4);
assertThat(iter.hasNext()).isTrue();
assertThat(next.getId().getId()).isEqualTo(partitionKey);
assertThat(next.getId().getCount()).isEqualTo(1);
assertThat(next.getId().getName()).isEqualTo("name5");
assertThat(next.getValue()).isEqualTo(clusteredValuePrefix + 5);
assertThat(iter.hasNext()).isFalse();
}