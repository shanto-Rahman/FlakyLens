@Test public void testClean() throws FontFormatException, IOException {
Assert.assertEquals(loadFont("/DejaVuSansMono.ttf").deriveFont((float)10),plain);
Assert.assertEquals(loadFont("/DejaVuSansMono-Bold.ttf").deriveFont((float)10),bold);
}