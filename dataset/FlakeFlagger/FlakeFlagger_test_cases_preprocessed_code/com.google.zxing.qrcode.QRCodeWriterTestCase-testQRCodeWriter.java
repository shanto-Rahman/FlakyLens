@Test public void testQRCodeWriter() throws WriterException {
assertNotNull(matrix);
assertEquals(bigEnough,matrix.getWidth());
assertEquals(bigEnough,matrix.getHeight());
assertNotNull(matrix);
assertTrue(tooSmall < matrix.getWidth());
assertTrue(tooSmall < matrix.getHeight());
assertNotNull(matrix);
assertEquals(strangeWidth,matrix.getWidth());
assertEquals(strangeHeight,matrix.getHeight());
}