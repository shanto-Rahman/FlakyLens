@Test void stringifySet(){
assertThat(sets).hasSize(strings.length);
assertThat(ParameterWriterHelper.toSql(writer)).isEqualTo(strings[i]);
}