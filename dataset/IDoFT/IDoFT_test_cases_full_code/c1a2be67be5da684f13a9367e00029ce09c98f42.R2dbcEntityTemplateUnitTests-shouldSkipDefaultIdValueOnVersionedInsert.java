@Test void shouldSkipDefaultIdValueOnVersionedInsert(){
  MockRowMetadata metadata=MockRowMetadata.builder().build();
  MockResult result=MockResult.builder().rowMetadata(metadata).rowsUpdated(1).build();
  recorder.addStubbing(s -> s.startsWith("INSERT"),result);
  entityTemplate.insert(new VersionedPersonWithPrimitiveId(0,0,"bar")).as(StepVerifier::create).assertNext(actual -> {
    assertThat(actual.getVersion()).isEqualTo(1);
  }
).verifyComplete();
  StatementRecorder.RecordedStatement statement=recorder.getCreatedStatement(s -> s.startsWith("INSERT"));
  assertThat(statement.getSql()).isEqualTo("INSERT INTO versioned_person_with_primitive_id (version, name) VALUES ($1, $2)");
  assertThat(statement.getBindings()).hasSize(2).containsEntry(0,Parameter.from(1L)).containsEntry(1,Parameter.from("bar"));
}
