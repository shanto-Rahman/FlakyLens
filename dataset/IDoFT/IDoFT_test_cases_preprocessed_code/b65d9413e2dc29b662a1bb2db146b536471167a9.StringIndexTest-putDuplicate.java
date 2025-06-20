@Test public void putDuplicate(){
assertEquals(aPointer + 1 + (2 + 4)+ 3+ "longer name".getBytes(Helper.UTF_CS).length,bPointer);
assertEquals(bPointer + 1 + 3+ "longer other name".getBytes(Helper.UTF_CS).length,cPointer);
assertEquals("longer name",index.get(aPointer,"a"));
assertEquals("longer name",index.get(aPointer,"b"));
assertEquals("longer other name",index.get(bPointer,"c"));
assertEquals("temp",index.get(cPointer,"temp"));
assertEquals(bPointer,cPointer);
assertEquals("{a=longer name, b=longer name}",index.getAll(aPointer).toString());
assertEquals("{a=longer name, b=longer name}",index.getAll(cPointer).toString());
}