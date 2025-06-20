@Test public void testTwoArrays(){
assertEquals("   c2 69 61                                        # ia\n" + "   82 20 00 00 00 04 00 00 00 00 00 00 00 00 00 00 # BinaryIntArrayReference\n" + "   00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00\n"+ "   00 00 00 00 00 c2 6c 61                         # la\n"+ "   82 50 00 00 00 08 00 00 00 00 00 00 00 00 00 00 # BinaryLongArrayReference\n"+ "   00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00\n"+ "   00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00\n"+ "   00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00\n"+ "   00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00\n"+ "   00 00 00 00 00\n",bytes.toHexString());
assertEquals(4,ta2.ia.getCapacity());
assertEquals(8,ta2.la.getCapacity());
assertEquals("   c2 69 61                                        # ia\n" + "   82 20 00 00 00 04 00 00 00 00 00 00 00 01 00 00 # BinaryIntArrayReference\n" + "   00 00 00 00 00 0b 00 00 00 00 00 00 00 00 00 00\n"+ "   00 00 00 00 00 c2 6c 61                         # la\n"+ "   82 50 00 00 00 08 00 00 00 00 00 00 00 02 00 00 # BinaryLongArrayReference\n"+ "   00 00 00 00 00 6f 00 00 00 00 00 00 00 de 00 00\n"+ "   00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00\n"+ "   00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00\n"+ "   00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00\n"+ "   00 00 00 00 00\n",bytes2.toHexString());
assertEquals(4,ta3.ia.getCapacity());
assertEquals(1,ta3.ia.getUsed());
assertEquals(11,ta3.ia.getValueAt(0));
assertEquals(8,ta3.la.getCapacity());
assertEquals(2,ta3.la.getUsed());
assertEquals(111,ta3.la.getValueAt(0));
assertEquals(222,ta3.la.getValueAt(1));
}