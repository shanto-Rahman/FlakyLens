@Test public void groupByStringMixedNumberOfRecords(){
  runner.setProperty("person-name","/name");
  readerService.addRecord("John",28,null);
  readerService.addRecord("Jake",49,null);
  readerService.addRecord("Mark",19,null);
  readerService.addRecord("Jane",20,null);
  readerService.addRecord("Jake",14,null);
  runner.enqueue(new byte[0]);
  runner.run();
  runner.assertTransferCount(PartitionRecord.REL_ORIGINAL,1);
  runner.assertTransferCount(PartitionRecord.REL_FAILURE,0);
  runner.assertTransferCount(PartitionRecord.REL_SUCCESS,4);
  final List<MockFlowFile> out=runner.getFlowFilesForRelationship(PartitionRecord.REL_SUCCESS);
  assertEquals(3L,out.stream().filter(ff -> ff.getAttribute("record.count").equals("1")).count());
  assertEquals(1L,out.stream().filter(ff -> ff.getAttribute("record.count").equals("2")).count());
  out.forEach(ff -> ff.assertAttributeEquals("fragment.count","4"));
  IntStream.of(1,3).forEach((i) -> out.get(i).assertAttributeEquals("fragment.id",out.get(0).getAttribute("fragment.id")));
  IntStream.of(0,3).forEach((i) -> out.get(i).assertAttributeEquals("fragment.index",String.valueOf(i)));
  out.stream().filter(ff -> ff.getAttribute("record.count").equals("2")).forEach(ff -> ff.assertContentEquals("Jake,49,\nJake,14,\n"));
  for (  final String name : new String[]{"John","Jake","Mark","Jane"}) {
    assertEquals(1L,out.stream().filter(ff -> ff.getAttribute("person-name").equals(name)).count());
  }
}
