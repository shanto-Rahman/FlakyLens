@Test void structuredNonExistingVariation(){
  when(fragmentRenderService.render(any(Resource.class))).thenReturn(MAIN_CONTENT);
  ContentFragment fragment=getModelInstanceUnderTest(CF_STRUCTURED_NON_EXISTING_VARIATION);
  assertContentFragment(fragment,TITLE,DESCRIPTION,STRUCTURED_TYPE,STRUCTURED_NAME,ASSOCIATED_CONTENT,MAIN,SECOND_STRUCTURED);
  Utils.testJSONExport(fragment,Utils.getTestExporterJSONPath(TEST_BASE,CF_STRUCTURED_NON_EXISTING_VARIATION));
}
