@Test public void addOtherDatabaseObjectIdentifierParameterSource(){
  SqlIdentifierParameterSource parameters=new SqlIdentifierParameterSource(identifierProcessing);
  parameters.addValue(SqlIdentifier.unquoted("key1"),111,11);
  parameters.addValue(SqlIdentifier.unquoted("key2"),111);
  SqlIdentifierParameterSource parameters2=new SqlIdentifierParameterSource(identifierProcessing);
  parameters2.addValue(SqlIdentifier.unquoted("key2"),222,22);
  parameters2.addValue(SqlIdentifier.unquoted("key3"),222);
  parameters.addAll(parameters2);
  assertSoftly(softly -> {
    softly.assertThat(parameters.getParameterNames()).isEqualTo(new String[]{"key1","key2","key3"});
    softly.assertThat(parameters.getValue("key1")).isEqualTo(111);
    softly.assertThat(parameters.hasValue("key1")).isTrue();
    softly.assertThat(parameters.getSqlType("key1")).isEqualTo(11);
    softly.assertThat(parameters.getValue("key2")).isEqualTo(222);
    softly.assertThat(parameters.hasValue("key2")).isTrue();
    softly.assertThat(parameters.getSqlType("key2")).isEqualTo(22);
    softly.assertThat(parameters.getValue("key3")).isEqualTo(222);
    softly.assertThat(parameters.hasValue("key3")).isTrue();
    softly.assertThat(parameters.getSqlType("key3")).isEqualTo(Integer.MIN_VALUE);
    softly.assertThat(parameters.getValue("blah")).isNull();
    softly.assertThat(parameters.hasValue("blah")).isFalse();
    softly.assertThat(parameters.getSqlType("blah")).isEqualTo(Integer.MIN_VALUE);
  }
);
}
