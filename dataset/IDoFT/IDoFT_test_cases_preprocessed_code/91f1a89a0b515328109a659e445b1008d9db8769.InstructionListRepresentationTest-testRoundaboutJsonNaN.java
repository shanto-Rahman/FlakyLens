@Test public void testRoundaboutJsonNaN() throws IOException {
InstructionList il=new InstructionList(usTR);//RW
assertEquals(objectMapper.readTree(fixture("fixtures/roundabout2.json")).toString(),objectMapper.valueToTree(il).toString());
}