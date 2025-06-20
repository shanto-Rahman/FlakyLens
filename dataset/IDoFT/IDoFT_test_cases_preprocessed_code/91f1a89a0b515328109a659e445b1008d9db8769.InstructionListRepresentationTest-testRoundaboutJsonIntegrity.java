@Test public void testRoundaboutJsonIntegrity() throws IOException {
InstructionList il=new InstructionList(usTR);//RW
assertEquals(objectMapper.readTree(fixture("fixtures/roundabout1.json")).toString(),objectMapper.valueToTree(il).toString());
}