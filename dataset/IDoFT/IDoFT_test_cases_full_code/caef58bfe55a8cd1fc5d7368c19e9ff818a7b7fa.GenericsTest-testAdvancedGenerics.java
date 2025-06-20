@Test public void testAdvancedGenerics() throws Exception {
  final Settings settings=TestUtils.settings();
  settings.outputKind=TypeScriptOutputKind.module;
  settings.addTypeNamePrefix="I";
  final StringWriter stringWriter=new StringWriter();
  new TypeScriptGenerator(settings).generateTypeScript(Input.from(A.class),Output.to(stringWriter));
  final String actual=stringWriter.toString().trim();
  final String nl=settings.newline;
  final String expected="export interface IA<U, V> {" + nl + "    x: IA<string, string>;"+ nl+ "    y: IA<IA<string, IB>, string[]>;"+ nl+ "    z: IA<{ [index: string]: V }, number[]>;"+ nl+ "}"+ nl+ ""+ nl+ "export interface IB {"+ nl+ "}";
  assertEquals(expected,actual);
  assertEquals("IA<string, string>",TestUtils.compileType(settings,A.class.getField("x").getGenericType()).toString());
  assertEquals("IA<IA<string, IB>, string[]>",TestUtils.compileType(settings,A.class.getField("y").getGenericType()).toString());
  assertEquals("IA<{ [index: string]: V }, number[]>",TestUtils.compileType(settings,A.class.getField("z").getGenericType()).toString());
}
