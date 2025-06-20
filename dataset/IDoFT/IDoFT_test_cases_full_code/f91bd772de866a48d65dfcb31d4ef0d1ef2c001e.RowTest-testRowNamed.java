@Test public void testRowNamed(){
  final Row row=Row.withNames(RowKind.DELETE);
  row.setField("a",42);
  row.setField("b",true);
  row.setField("c",null);
  assertThat(row.getFieldNames(false),containsInAnyOrder("a","b","c"));
  assertThat(row.getArity(),equalTo(3));
  assertThat(row.getKind(),equalTo(RowKind.DELETE));
  assertThat(row.getField("a"),equalTo(42));
  assertThat(row.getField("b"),equalTo(true));
  assertThat(row.getField("c"),equalTo(null));
  assertThat(row.toString(),equalTo("-D{a=42, b=true, c=null}"));
  row.setField("a",13);
  row.setField("c","Hello");
  assertThat(row.getField("a"),equalTo(13));
  assertThat(row.getField("b"),equalTo(true));
  assertThat(row.getField("c"),equalTo("Hello"));
  final Row otherRow1=Row.withNames(RowKind.DELETE);
  otherRow1.setField("a",13);
  otherRow1.setField("b",true);
  otherRow1.setField("c","Hello");
  assertThat(row.hashCode(),equalTo(otherRow1.hashCode()));
  assertThat(row,equalTo(otherRow1));
  final Row otherRow2=Row.withNames(RowKind.DELETE);
  otherRow2.setField("a",13);
  otherRow2.setField("b",false);
  otherRow2.setField("c","Hello");
  assertThat(row.hashCode(),not(equalTo(otherRow2.hashCode())));
  assertThat(row,not(equalTo(otherRow2)));
  row.clear();
  assertThat(row.getArity(),equalTo(0));
  assertThat(row.getFieldNames(false),empty());
  assertThat(row.toString(),equalTo("-D{}"));
  try {
    row.setField(0,13);
    fail();
  }
 catch (  Throwable t) {
    assertThat(t,hasMessage(containsString("not supported in name-based field mode")));
  }
  try {
    assertNull(row.getField(0));
    fail();
  }
 catch (  Throwable t) {
    assertThat(t,hasMessage(containsString("not supported in name-based field mode")));
  }
}
