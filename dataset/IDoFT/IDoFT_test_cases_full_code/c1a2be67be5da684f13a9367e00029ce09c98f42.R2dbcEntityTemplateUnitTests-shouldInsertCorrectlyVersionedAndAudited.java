@Test void shouldInsertCorrectlyVersionedAndAudited(){
  MockRowMetadata metadata=MockRowMetadata.builder().build();
  MockResult result=MockResult.builder().rowMetadata(metadata).rowsUpdated(1).build();
  recorder.addStubbing(s -> s.startsWith("INSERT"),result);
  ObjectFactory<ReactiveIsNewAwareAuditingHandler> objectFactory=mock(ObjectFactory.class);
  when(objectFactory.getObject()).thenReturn(new ReactiveIsNewAwareAuditingHandler(PersistentEntities.of(entityTemplate.getConverter().getMappingContext())));
  entityTemplate.setEntityCallbacks(ReactiveEntityCallbacks.create(new ReactiveAuditingEntityCallback(objectFactory)));
  entityTemplate.insert(new WithAuditingAndOptimisticLocking(null,0,"Walter",null,null)).as(StepVerifier::create).assertNext(actual -> {
    assertThat(actual.getVersion()).isEqualTo(1);
    assertThat(actual.getCreatedDate()).isNotNull();
  }
).verifyComplete();
  StatementRecorder.RecordedStatement statement=recorder.getCreatedStatement(s -> s.startsWith("INSERT"));
  assertThat(statement.getSql()).isEqualTo("INSERT INTO with_auditing_and_optimistic_locking (version, name, created_date, last_modified_date) VALUES ($1, $2, $3, $4)");
}
