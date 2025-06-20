@Test public void testRepository(){
  PersonHash personHash=new PersonHash();
  personHash.setDescription("Look, new @DataRedisTest!");
  assertThat(personHash.getId()).isNull();
  PersonHash savedEntity=this.exampleRepository.save(personHash);
  assertThat(savedEntity.getId()).isNotNull();
  assertThat(this.operations.execute((  RedisConnection connection) -> connection.exists(("persons:" + savedEntity.getId()).getBytes(CHARSET)))).isTrue();
  this.exampleRepository.deleteAll();
}
