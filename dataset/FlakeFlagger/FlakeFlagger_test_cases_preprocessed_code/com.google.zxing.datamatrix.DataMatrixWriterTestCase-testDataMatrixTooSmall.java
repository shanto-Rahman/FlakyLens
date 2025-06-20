@Test public void testDataMatrixTooSmall(){
assertNotNull(matrix);
assertTrue(tooSmall < matrix.getWidth());
assertTrue(tooSmall < matrix.getHeight());
}