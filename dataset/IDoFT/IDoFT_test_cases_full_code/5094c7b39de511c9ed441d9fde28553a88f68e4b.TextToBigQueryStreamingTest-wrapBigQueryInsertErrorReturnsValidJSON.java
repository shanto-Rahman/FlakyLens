@Test public void wrapBigQueryInsertErrorReturnsValidJSON(){
  TableRow testRow=new TableRow().set(NAME_KEY,testPerson.name).set(AGE_KEY,testPerson.age);
  InsertErrors insertErrors=new TableDataInsertAllResponse.InsertErrors();
  ErrorProto errorProto=new ErrorProto().setMessage(ERROR_MESSAGE);
  insertErrors.setErrors(ImmutableList.of(errorProto));
  TableReference tableReference=new TableReference();
  BigQueryInsertError bigQueryInsertError=new BigQueryInsertError(testRow.clone(),insertErrors,tableReference);
  String expected=GSON.toJson(testPerson);
  FailsafeElement<String,String> wrappedValue=TextToBigQueryStreaming.wrapBigQueryInsertError(bigQueryInsertError);
  String actualOriginalPayload=wrappedValue.getOriginalPayload();
  String actualPayload=wrappedValue.getPayload();
  String actualErrorMessage=wrappedValue.getErrorMessage();
  assertThat(actualOriginalPayload).isEqualTo(expected);
  assertThat(actualPayload).isEqualTo(expected);
  assertThat(actualErrorMessage).isEqualTo(GSON.toJson(insertErrors));
}
