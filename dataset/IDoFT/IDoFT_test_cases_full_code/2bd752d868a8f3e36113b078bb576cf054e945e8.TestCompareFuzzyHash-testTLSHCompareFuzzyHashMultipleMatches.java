@Test public void testTLSHCompareFuzzyHashMultipleMatches(){
  double matchingSimilarity=200;
  runner.setProperty(CompareFuzzyHash.HASH_ALGORITHM,CompareFuzzyHash.allowableValueTLSH.getValue());
  runner.setProperty(CompareFuzzyHash.ATTRIBUTE_NAME,"fuzzyhash.value");
  runner.setProperty(CompareFuzzyHash.HASH_LIST_FILE,"src/test/resources/tlsh.list");
  runner.setProperty(CompareFuzzyHash.MATCH_THRESHOLD,String.valueOf(matchingSimilarity));
  runner.setProperty(CompareFuzzyHash.MATCHING_MODE,CompareFuzzyHash.multiMatch.getValue());
  Map<String,String> attributes=new HashMap<>();
  attributes.put("fuzzyhash.value",tlshInput);
  runner.enqueue("bogus".getBytes(),attributes);
  runner.run();
  runner.assertQueueEmpty();
  runner.assertAllFlowFilesTransferred(CompareFuzzyHash.REL_FOUND,1);
  final MockFlowFile outFile=runner.getFlowFilesForRelationship(CompareFuzzyHash.REL_FOUND).get(0);
  outFile.assertAttributeEquals("fuzzyhash.value.0.match","nifi-nar-bundles/nifi-lumberjack-bundle/nifi-lumberjack-processors/pom.xml");
  double similarity=Double.valueOf(outFile.getAttribute("fuzzyhash.value.0.similarity"));
  Assert.assertTrue(similarity <= matchingSimilarity);
  outFile.assertAttributeEquals("fuzzyhash.value.1.match","nifi-nar-bundles/nifi-beats-bundle/nifi-beats-processors/pom.xml");
  similarity=Double.valueOf(outFile.getAttribute("fuzzyhash.value.1.similarity"));
  Assert.assertTrue(similarity <= matchingSimilarity);
}
