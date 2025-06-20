@Test void structuredVariation(){
  ContentFragment fragment=getModelInstanceUnderTest(CF_STRUCTURED_VARIATION);
  assertContentFragment(fragment,VARIATION_NAME,TITLE,DESCRIPTION,STRUCTURED_TYPE,STRUCTURED_NAME,ASSOCIATED_CONTENT,MAIN,SECOND_STRUCTURED);
  Utils.testJSONExport(fragment,Utils.getTestExporterJSONPath(TEST_BASE,CF_STRUCTURED_VARIATION));
}
