@Test public void basicTest(){
  final List<String> lines=new ArrayList<>();
  final EmitterExtension.Writer writer=new EmitterExtension.Writer(){
    @Override public void writeIndentedLine(    String line){
      lines.add(line);
    }
  }
;
  final Settings settings=new Settings();
  settings.sortDeclarations=true;
  final TypeProcessor typeProcessor=new DefaultTypeProcessor();
  final Model model=new Jackson2Parser(settings,typeProcessor).parseModel(Direction.class);
  final TsModel tsModel=new ModelCompiler(settings,typeProcessor).javaToTypeScript(model);
  new EnumConstantsExtension().emitElements(writer,settings,false,tsModel);
  String indent=settings.indentString;
  Assert.assertEquals(7,lines.size());
  Assert.assertEquals("",lines.get(0));
  Assert.assertEquals("const Direction = {",lines.get(1));
  Assert.assertEquals(indent + "North: <Direction>\"North\",",lines.get(2));
  Assert.assertEquals(indent + "East: <Direction>\"East\",",lines.get(3));
  Assert.assertEquals(indent + "South: <Direction>\"South\",",lines.get(4));
  Assert.assertEquals(indent + "West: <Direction>\"West\",",lines.get(5));
  Assert.assertEquals("}",lines.get(6));
}
