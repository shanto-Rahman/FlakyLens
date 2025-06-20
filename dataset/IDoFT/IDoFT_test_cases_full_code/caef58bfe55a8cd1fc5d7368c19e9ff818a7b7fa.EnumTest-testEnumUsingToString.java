@Test public void testEnumUsingToString(){
  final Settings settings=TestUtils.settings();
  settings.jackson2Configuration=new Jackson2ConfigurationResolved();
  settings.jackson2Configuration.enumsUsingToString=true;
  final String output=new TypeScriptGenerator(settings).generateTypeScript(Input.from(SideUsingToString.class));
  final String expected=("\n" + "type SideUsingToString = 'toString:left-side' | 'toString:right-side';\n").replace("'","\"");
  assertEquals(expected,output);
}
