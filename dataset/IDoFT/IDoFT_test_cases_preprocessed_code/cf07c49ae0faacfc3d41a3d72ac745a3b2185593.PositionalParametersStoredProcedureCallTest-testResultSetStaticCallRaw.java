@Test public void testResultSetStaticCallRaw() throws Exception {
assertThat(listResult).hasSize(2);
assertThat(((Number)listResult.get(0)).intValue()).isEqualTo(2);
assertThat(listResult.get(1)).isEqualTo("title'2");
}