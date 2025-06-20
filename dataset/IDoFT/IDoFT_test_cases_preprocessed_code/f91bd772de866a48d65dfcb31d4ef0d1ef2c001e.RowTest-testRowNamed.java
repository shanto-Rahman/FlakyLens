@Test public void testRowNamed(){
assertThat(row.getFieldNames(false),containsInAnyOrder("a","b","c"));
assertThat(row.getArity(),equalTo(3));
assertThat(row.getKind(),equalTo(RowKind.DELETE));
assertThat(row.getField("a"),equalTo(42));
assertThat(row.getField("b"),equalTo(true));
assertThat(row.getField("c"),equalTo(null));
assertThat(row.toString(),equalTo("-D{a=42, b=true, c=null}"));
assertThat(row.getField("a"),equalTo(13));
assertThat(row.getField("b"),equalTo(true));
assertThat(row.getField("c"),equalTo("Hello"));
assertThat(row.hashCode(),equalTo(otherRow1.hashCode()));
assertThat(row,equalTo(otherRow1));
assertThat(row.hashCode(),not(equalTo(otherRow2.hashCode())));
assertThat(row,not(equalTo(otherRow2)));
assertThat(row.getArity(),equalTo(0));
assertThat(row.getFieldNames(false),empty());
assertThat(row.toString(),equalTo("-D{}"));
fail();
assertThat(t,hasMessage(containsString("not supported in name-based field mode")));
assertNull(row.getField(0));
fail();
assertThat(t,hasMessage(containsString("not supported in name-based field mode")));
}