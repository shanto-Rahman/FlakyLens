@Test public void testGetRow(){
if ((x & 0x03) == 0) {
}
assertEquals(102,array.getSize());
assertEquals(102,array2.getSize());
assertEquals(200,array3.getSize());
assertEquals(on,array.get(x));
assertEquals(on,array2.get(x));
assertEquals(on,array3.get(x));
}