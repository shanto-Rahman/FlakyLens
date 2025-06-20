@Test public void testValidateJsonTimestamp() throws IOException, InitializationException {
validFlowFile.assertContentEquals(new File("src/test/resources/TestValidateRecord/timestamp.json"));//RO
invalidFlowFile.assertContentEquals(new File("src/test/resources/TestValidateRecord/timestamp.json"));//RO
validFlowFileInferredSchema.assertContentEquals(new File("src/test/resources/TestValidateRecord/timestamp.json"));//RO
}