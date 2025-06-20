@Test public void putDuplicate(){
  StringIndex index=create();
  long aPointer=index.add(createMap("a","longer name","b","longer name"));
  long bPointer=index.add(createMap("c","longer other name"));
  assertEquals(aPointer + 1 + (2 + 4)+ 3+ "longer name".getBytes(Helper.UTF_CS).length,bPointer);
  long cPointer=index.add(createMap("temp","temp"));
  assertEquals(bPointer + 1 + 3+ "longer other name".getBytes(Helper.UTF_CS).length,cPointer);
  assertEquals("longer name",index.get(aPointer,"a"));
  assertEquals("longer name",index.get(aPointer,"b"));
  assertEquals("longer other name",index.get(bPointer,"c"));
  assertEquals("temp",index.get(cPointer,"temp"));
  index=create();
  index.add(createMap("a","longer name","b","longer name"));
  bPointer=index.add(createMap("a","longer name","b","longer name"));
  cPointer=index.add(createMap("a","longer name","b","longer name"));
  assertEquals(bPointer,cPointer);
  assertEquals("{a=longer name, b=longer name}",index.getAll(aPointer).toString());
  assertEquals("{a=longer name, b=longer name}",index.getAll(cPointer).toString());
}
