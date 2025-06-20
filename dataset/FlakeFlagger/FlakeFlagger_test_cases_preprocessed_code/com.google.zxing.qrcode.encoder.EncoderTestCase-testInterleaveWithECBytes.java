@Test public void testInterleaveWithECBytes() throws WriterException {
assertEquals(expected.length,out.getSizeInBytes());
assertEquals(expected[x],outArray[x]);
assertEquals(expected.length,out.getSizeInBytes());
assertEquals(expected[x],outArray[x]);
}