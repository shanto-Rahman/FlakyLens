@Test public void testSkip() throws IOException {
Assert.assertEquals(10,in.skip(10));
Assert.assertTrue(in.read() == -1);
Assert.assertEquals(9,in.skip(10));
Assert.assertTrue(in.read() == -1);
Assert.assertTrue(in.skip(10) <= 0);
Assert.assertTrue(in.skip(-1) == 0);
Assert.assertTrue(in.read() == -1);
Assert.assertEquals(5,in.skip(5));
Assert.assertEquals(5,in.read(new byte[20]));
}