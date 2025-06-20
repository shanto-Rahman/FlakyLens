@Test public void testSplitWithParameters(){
  runner.setProperty(ExecuteStateless.DATAFLOW_FILE,"src/test/resources/split-text.json");
  runner.setProperty(ExecuteStateless.INPUT_PORT,"In");
  runner.setProperty("Lines Per Split","3");
  runner.enqueue("The\nQuick\nBrown\nFox\nJumps\nOver\nThe\nLazy\nDog".getBytes(),Collections.singletonMap("abc","xyz"));
  runner.run();
  runner.assertTransferCount(ExecuteStateless.REL_OUTPUT,3);
  final List<MockFlowFile> output=runner.getFlowFilesForRelationship(ExecuteStateless.REL_OUTPUT);
  output.forEach(ff -> ff.assertAttributeEquals("abc","xyz"));
  output.get(0).assertContentEquals("The\nQuick\nBrown");
  output.get(1).assertContentEquals("Fox\nJumps\nOver");
  output.get(2).assertContentEquals("The\nLazy\nDog");
}
