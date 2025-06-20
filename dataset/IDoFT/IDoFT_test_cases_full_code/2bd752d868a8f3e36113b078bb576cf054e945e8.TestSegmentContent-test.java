@Test public void test() throws IOException {
  final TestRunner testRunner=TestRunners.newTestRunner(new SegmentContent());
  testRunner.setProperty(SegmentContent.SIZE,"4 B");
  testRunner.enqueue(new byte[]{1,2,3,4,5,6,7,8,9});
  testRunner.run();
  testRunner.assertTransferCount(SegmentContent.REL_ORIGINAL,1);
  final MockFlowFile originalFlowFile=testRunner.getFlowFilesForRelationship(SegmentContent.REL_ORIGINAL).get(0);
  originalFlowFile.assertAttributeExists(SegmentContent.FRAGMENT_ID);
  originalFlowFile.assertAttributeEquals(SegmentContent.FRAGMENT_COUNT,"3");
  final List<MockFlowFile> flowFiles=testRunner.getFlowFilesForRelationship(SegmentContent.REL_SEGMENTS);
  assertEquals(3,flowFiles.size());
  final MockFlowFile out1=flowFiles.get(0);
  final MockFlowFile out2=flowFiles.get(1);
  final MockFlowFile out3=flowFiles.get(2);
  out1.assertContentEquals(new byte[]{1,2,3,4});
  out2.assertContentEquals(new byte[]{5,6,7,8});
  out3.assertContentEquals(new byte[]{9});
}
