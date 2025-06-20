@Test public void wrapBigQueryInsertErrorReturnsValidJSON(){
TableRow testRow=new TableRow().set(NAME_KEY,testPerson.name).set(AGE_KEY,testPerson.age);//RW
String expected=GSON.toJson(testPerson);//RW
assertThat(actualOriginalPayload).isEqualTo(expected);
assertThat(actualPayload).isEqualTo(expected);
assertThat(actualErrorMessage).isEqualTo(GSON.toJson(insertErrors));
}