@Test void shouldUpdateCorrectlyVersionedAndAudited(){
  MockRowMetadata metadata=MockRowMetadata.builder().build();
  MockResult result=MockResult.builder().rowMetadata(metadata).rowsUpdated(1).build();
  recorder.addStubbing(s -> s.startsWith("UPDATE"),result);
  ObjectFactory<ReactiveIsNewAwareAuditingHandler> objectFactory=mock(ObjectFactory.class);
  when(objectFactory.getObject()).thenReturn(new ReactiveIsNewAwareAuditingHandler(PersistentEntities.of(entityTemplate.getConverter().getMappingContext())));
  entityTemplate.setEntityCallbacks(ReactiveEntityCallbacks.create(new ReactiveAuditingEntityCallback(objectFactory)));
  entityTemplate.update(new WithAuditingAndOptimisticLocking(null,2,"Walter",null,null)).as(StepVerifier::create).assertNext(actual -> {
    assertThat(actual.getVersion()).isEqualTo(3);
    assertThat(actual.getCreatedDate()).isNull();
    assertThat(actual.getLastModifiedDate()).isNotNull();
  }
).verifyComplete();
  StatementRecorder.RecordedStatement statement=recorder.getCreatedStatement(s -> s.startsWith("UPDATE"));
  assertThat(statement.getSql()).startsWith("UPDATE with_auditing_and_optimistic_locking SET version = $1, name = $2, created_date = $3, last_modified_date = $4");
}
