@Test void updateShouldInvokeCallback(){
  MockRowMetadata metadata=MockRowMetadata.builder().build();
  MockResult result=MockResult.builder().rowMetadata(metadata).rowsUpdated(1).build();
  recorder.addStubbing(s -> s.startsWith("UPDATE"),result);
  ValueCapturingBeforeConvertCallback beforeConvert=new ValueCapturingBeforeConvertCallback();
  ValueCapturingBeforeSaveCallback beforeSave=new ValueCapturingBeforeSaveCallback();
  ValueCapturingAfterSaveCallback afterSave=new ValueCapturingAfterSaveCallback();
  Person person=new Person();
  person.id="the-id";
  person.name="name";
  person.description="description";
  entityTemplate.setEntityCallbacks(ReactiveEntityCallbacks.create(beforeConvert,beforeSave,afterSave));
  entityTemplate.update(person).as(StepVerifier::create).assertNext(actual -> {
    assertThat(actual.id).isEqualTo("after-save");
    assertThat(actual.name).isEqualTo("before-convert");
    assertThat(actual.description).isNull();
  }
).verifyComplete();
  StatementRecorder.RecordedStatement statement=recorder.getCreatedStatement(s -> s.startsWith("UPDATE"));
  assertThat(statement.getSql()).isEqualTo("UPDATE person SET THE_NAME = $1, description = $2 WHERE person.id = $3");
  assertThat(statement.getBindings()).hasSize(3).containsEntry(0,Parameter.from("before-convert")).containsEntry(1,Parameter.from("before-save"));
}
