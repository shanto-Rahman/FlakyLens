@Test public void testParser(){
  final Settings settings=TestUtils.settings();
  final ModelParser parser=new TypeScriptGenerator(settings).getModelParser();
  final Model model=parser.parseModel(SomeCode.class);
  Assert.assertEquals(1,model.getEnums().size());
  final EnumModel enumModel=model.getEnums().get(0);
  Assert.assertEquals(EnumKind.NumberBased,enumModel.getKind());
  Assert.assertEquals(2,enumModel.getMembers().size());
  Assert.assertEquals(10,((Number)enumModel.getMembers().get(0).getEnumValue()).intValue());
  Assert.assertEquals(11,((Number)enumModel.getMembers().get(1).getEnumValue()).intValue());
}
