@Test public void testLoadKeys(){
  String location="./target/stringindex-store";
  Helper.removeDir(new File(location));
  StringIndex index=new StringIndex(new RAMDirectory(location,true).create(),1000,-1).create(1000);
  long pointerA=index.add(createMap("c","test value"));
  assertEquals(2,index.getKeys().size());
  long pointerB=index.add(createMap("a","value","b","another value"));
  assertEquals("[, c, a, b]",index.getKeys().toString());
  index.flush();
  index.close();
  index=new StringIndex(new RAMDirectory(location,true),1000,-1);
  assertTrue(index.loadExisting());
  assertEquals("[, c, a, b]",index.getKeys().toString());
  assertEquals("test value",index.get(pointerA,"c"));
  assertNull(index.get(pointerA,"b"));
  assertNull(index.get(pointerB,""));
  assertEquals("value",index.get(pointerB,"a"));
  assertEquals("another value",index.get(pointerB,"b"));
  assertEquals("{a=value, b=another value}",index.getAll(pointerB).toString());
  index.close();
  Helper.removeDir(new File(location));
}
