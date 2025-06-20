@Test public void testRepository(){
assertThat(personHash.getId()).isNull();
assertThat(savedEntity.getId()).isNotNull();
assertThat(this.operations.execute((RedisConnection connection) -> connection.exists(("persons:" + savedEntity.getId()).getBytes(CHARSET)))).isTrue();
}