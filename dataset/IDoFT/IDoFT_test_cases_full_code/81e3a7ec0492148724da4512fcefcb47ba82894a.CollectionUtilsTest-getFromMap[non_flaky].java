@Test public void getFromMap(){
  final Map<String,String> expected=new HashMap<>();
  expected.put("zeroKey","zero");
  expected.put("oneKey","one");
  Map.Entry<String,String> entry=CollectionUtils.get(expected,0);
  assertTrue(entry.toString().equals("zeroKey=zero") || entry.toString().equals("oneKey=one"));
  entry=CollectionUtils.get(expected,1);
  assertTrue(entry.toString().equals("zeroKey=zero") || entry.toString().equals("oneKey=one"));
  try {
    CollectionUtils.get(expected,2);
    fail("Expecting IndexOutOfBoundsException.");
  }
 catch (  final IndexOutOfBoundsException e) {
  }
  try {
    CollectionUtils.get(expected,-2);
    fail("Expecting IndexOutOfBoundsException.");
  }
 catch (  final IndexOutOfBoundsException e) {
  }
  final SortedMap<String,String> map=new TreeMap<>();
  map.put("zeroKey","zero");
  map.put("oneKey","one");
  Map.Entry<String,String> test=CollectionUtils.get(map,1);
  assertEquals("zeroKey",test.getKey());
  assertEquals("zero",test.getValue());
  test=CollectionUtils.get(map,0);
  assertEquals("oneKey",test.getKey());
  assertEquals("one",test.getValue());
}
