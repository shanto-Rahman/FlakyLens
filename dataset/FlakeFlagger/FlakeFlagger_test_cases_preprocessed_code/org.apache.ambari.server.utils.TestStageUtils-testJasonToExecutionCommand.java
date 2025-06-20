@Test public void testJasonToExecutionCommand() throws JsonGenerationException, JsonMappingException, JAXBException, IOException {
assertEquals(cmd.toString(),cmdDes.toString());
assertEquals(cmd,cmdDes);
}