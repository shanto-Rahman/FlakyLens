@Test void structured(){
  ContentFragment fragment=getModelInstanceUnderTest(CF_STRUCTURED);
  assertContentFragment(fragment,TITLE,DESCRIPTION,STRUCTURED_TYPE,STRUCTURED_NAME,ASSOCIATED_CONTENT,MAIN,SECOND_STRUCTURED);
  Utils.testJSONExport(fragment,Utils.getTestExporterJSONPath(TEST_BASE,CF_STRUCTURED));
}
