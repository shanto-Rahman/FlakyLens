@Test public void testEnumWithJsonValueMethodAnnotation(){
  final Settings settings=TestUtils.settings();
  final String output=new TypeScriptGenerator(settings).generateTypeScript(Input.from(SideWithJsonValueMethodAnnotation.class));
  final String expected=("\n" + "type SideWithJsonValueMethodAnnotation = 'left-side' | 'right-side';\n").replace("'","\"");
  assertEquals(expected,output);
}
