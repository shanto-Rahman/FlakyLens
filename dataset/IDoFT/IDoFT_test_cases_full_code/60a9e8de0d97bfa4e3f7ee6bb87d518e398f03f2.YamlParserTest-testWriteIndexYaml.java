@Test public void testWriteIndexYaml() throws Exception {
  InputStream expected=getClass().getResourceAsStream("indexresult.yaml");
  StringWriter writer=new StringWriter();
  IOUtils.copy(expected,writer);
  String expectedResult=writer.toString();
  OutputStream os=new ByteArrayOutputStream();
  underTest.write(os,createChartIndex());
  assertThat(os,is(notNullValue()));
  assertEquals(os.toString(),expectedResult);
}
