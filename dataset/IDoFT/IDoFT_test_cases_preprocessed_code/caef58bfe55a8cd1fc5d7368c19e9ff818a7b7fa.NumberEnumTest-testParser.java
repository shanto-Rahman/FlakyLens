@Test public void testParser(){
final Model model=parser.parseModel(SomeCode.class);//RW
Assert.assertEquals(1,model.getEnums().size());
Assert.assertEquals(EnumKind.NumberBased,enumModel.getKind());
Assert.assertEquals(2,enumModel.getMembers().size());
Assert.assertEquals(10,((Number)enumModel.getMembers().get(0).getEnumValue()).intValue());
Assert.assertEquals(11,((Number)enumModel.getMembers().get(1).getEnumValue()).intValue());
}