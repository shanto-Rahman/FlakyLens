@Test public void testIsRange(){
assertTrue(array.isRange(0,64,false));
assertFalse(array.isRange(0,64,true));
assertTrue(array.isRange(32,33,true));
assertTrue(array.isRange(31,33,true));
assertFalse(array.isRange(31,35,true));
assertTrue(array.isRange(0,33,true));
assertTrue(array.isRange(0,64,true));
assertFalse(array.isRange(0,64,false));
}