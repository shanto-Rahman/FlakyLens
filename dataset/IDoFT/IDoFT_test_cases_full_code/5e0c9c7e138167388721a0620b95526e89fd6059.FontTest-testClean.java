@Test public void testClean() throws FontFormatException, IOException {
  RrdGraphConstants.FontConstructor.refreshConf();
  Font plain=RrdGraphConstants.FontConstructor.getFont(Font.PLAIN,10);
  Font bold=RrdGraphConstants.FontConstructor.getFont(Font.BOLD,10);
  Assert.assertEquals(loadFont("/DejaVuSansMono.ttf").deriveFont((float)10),plain);
  Assert.assertEquals(loadFont("/DejaVuSansMono-Bold.ttf").deriveFont((float)10),bold);
}
