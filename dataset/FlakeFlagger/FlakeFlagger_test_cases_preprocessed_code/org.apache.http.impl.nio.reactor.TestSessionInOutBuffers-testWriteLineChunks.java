@Test public void testWriteLineChunks() throws Exception {
Assert.assertTrue(inbuf.readLine(line,false));
Assert.assertEquals("One",line.toString());
Assert.assertTrue(inbuf.readLine(line,false));
Assert.assertEquals("Two",line.toString());
Assert.assertFalse(inbuf.readLine(line,false));
Assert.assertTrue(inbuf.readLine(line,false));
Assert.assertEquals("Three",line.toString());
Assert.assertTrue(inbuf.readLine(line,true));
Assert.assertEquals("Four",line.toString());
Assert.assertFalse(inbuf.readLine(line,true));
Assert.assertEquals("One\r\nTwo\r\nThree\r\nFour\r\n",s);
}