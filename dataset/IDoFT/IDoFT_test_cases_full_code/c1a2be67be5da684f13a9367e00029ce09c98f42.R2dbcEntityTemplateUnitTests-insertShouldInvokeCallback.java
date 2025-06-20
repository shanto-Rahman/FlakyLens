@Test void insertShouldInvokeCallback(){
  MockRowMetadata metadata=MockRowMetadata.builder().build();
  MockResult result=MockResult.builder().rowMetadata(metadata).rowsUpdated(1).build();
  recorder.addStubbing(s -> s.startsWith("INSERT"),result);
  ValueCapturingBeforeConvertCallback beforeConvert=new ValueCapturingBeforeConvertCallback();
  ValueCapturingBeforeSaveCallback beforeSave=new ValueCapturingBeforeSaveCallback();
  ValueCapturingAfterSaveCallback afterSave=new ValueCapturingAfterSaveCallback();
  entityTemplate.setEntityCallbacks(ReactiveEntityCallbacks.create(beforeConvert,beforeSave,afterSave));
  entityTemplate.insert(new Person()).as(StepVerifier::create).assertNext(actual -> {
    assertThat(actual.id).isEqualTo("after-save");
    assertThat(actual.name).isEqualTo("before-convert");
    assertThat(actual.description).isNull();
  }
).verifyComplete();
  StatementRecorder.RecordedStatement statement=recorder.getCreatedStatement(s -> s.startsWith("INSERT"));
  assertThat(statement.getSql()).isEqualTo("INSERT INTO person (THE_NAME, description) VALUES ($1, $2)");
  assertThat(statement.getBindings()).hasSize(2).containsEntry(0,Parameter.from("before-convert")).containsEntry(1,Parameter.from("before-save"));
}
