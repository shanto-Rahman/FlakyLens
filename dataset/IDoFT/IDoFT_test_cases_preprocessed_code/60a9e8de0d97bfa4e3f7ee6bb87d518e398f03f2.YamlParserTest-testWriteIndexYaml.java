@Test public void testWriteIndexYaml() throws Exception {
assertThat(os,is(notNullValue()));
assertEquals(os.toString(),expectedResult);
}