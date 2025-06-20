@Test void shouldInsertVersioned(){
  MockRowMetadata metadata=MockRowMetadata.builder().build();
  MockResult result=MockResult.builder().rowMetadata(metadata).rowsUpdated(1).build();
  recorder.addStubbing(s -> s.startsWith("INSERT"),result);
  entityTemplate.insert(new VersionedPerson("id",0,"bar")).as(StepVerifier::create).assertNext(actual -> {
    assertThat(actual.getVersion()).isEqualTo(1);
  }
).verifyComplete();
  StatementRecorder.RecordedStatement statement=recorder.getCreatedStatement(s -> s.startsWith("INSERT"));
  assertThat(statement.getSql()).isEqualTo("INSERT INTO versioned_person (id, version, name) VALUES ($1, $2, $3)");
  assertThat(statement.getBindings()).hasSize(3).containsEntry(0,Parameter.from("id")).containsEntry(1,Parameter.from(1L));
}
