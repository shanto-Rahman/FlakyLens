@Test public void testSingleEnum(){
  final Settings settings=TestUtils.settings();
  final String output=new TypeScriptGenerator(settings).generateTypeScript(Input.from(Direction.class));
  final String expected=("\n" + "type Direction = 'North' | 'East' | 'South' | 'West';\n").replace("'","\"");
  assertEquals(expected,output);
}
