@Test public void testEnumQueryParam(){
  final Settings settings=TestUtils.settings();
  settings.generateJaxrsApplicationInterface=true;
  final String output=new TypeScriptGenerator(settings).generateTypeScript(Input.from(EnumQueryParamResource.class));
  Assert.assertTrue(output.contains("queryParams?: { target?: TargetEnum; }"));
  Assert.assertTrue(output.contains("type TargetEnum = \"Target1\" | \"Target2\""));
}
