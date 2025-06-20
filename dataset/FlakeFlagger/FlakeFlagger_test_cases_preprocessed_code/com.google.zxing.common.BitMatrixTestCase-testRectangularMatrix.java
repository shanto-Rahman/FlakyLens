@Test public void testRectangularMatrix(){
assertEquals(75,matrix.getWidth());
assertEquals(20,matrix.getHeight());
assertTrue(matrix.get(10,0));
assertTrue(matrix.get(11,1));
assertTrue(matrix.get(50,2));
assertTrue(matrix.get(51,3));
assertTrue(matrix.get(74,4));
assertTrue(matrix.get(0,5));
assertFalse(matrix.get(50,2));
assertFalse(matrix.get(51,3));
}