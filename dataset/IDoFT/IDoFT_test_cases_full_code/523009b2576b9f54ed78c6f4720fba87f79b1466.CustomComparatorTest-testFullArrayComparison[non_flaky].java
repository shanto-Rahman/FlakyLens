@Test public void testFullArrayComparison() throws Exception {
  JSONCompareResult compareResult=JSONCompare.compareJSON("[{id:1}, {id:3}, {id:5}]","[{id:1}, {id:3}, {id:6}, {id:7}]",new ArrayOfJsonObjectsComparator(JSONCompareMode.LENIENT));
  Assert.assertTrue(compareResult.failed());
  String message=compareResult.getMessage().replaceAll("\n","");
  Assert.assertTrue(message,message.matches("(?:.*id=(?:5.*Expected|6.*Unexpected|7.*Unexpected)){3}.*"));
}
