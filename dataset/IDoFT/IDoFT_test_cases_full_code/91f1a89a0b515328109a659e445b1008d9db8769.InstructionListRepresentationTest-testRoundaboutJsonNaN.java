@Test public void testRoundaboutJsonNaN() throws IOException {
  ObjectMapper objectMapper=Jackson.newObjectMapper();
  InstructionList il=new InstructionList(usTR);
  PointList pl=new PointList();
  pl.add(52.514,13.349);
  pl.add(52.5135,13.35);
  pl.add(52.514,13.351);
  RoundaboutInstruction instr=new RoundaboutInstruction(Instruction.USE_ROUNDABOUT,"streetname",new InstructionAnnotation(0,""),pl).setRadian(-Math.PI + 1).setExitNumber(2).setExited();
  il.add(instr);
  assertEquals(objectMapper.readTree(fixture("fixtures/roundabout2.json")).toString(),objectMapper.valueToTree(il).toString());
}
