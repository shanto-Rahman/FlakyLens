@Test public void testParamsFormatting() throws Exception {
Assert.assertEquals("param=regular_stuff; param=\"this\\\\that\"; param=\"this,that\"",BasicHeaderValueFormatter.formatParameters(params,false,null));
Assert.assertEquals("param=\"regular_stuff\"; param=\"this\\\\that\"; param=\"this,that\"",BasicHeaderValueFormatter.formatParameters(params,true,null));
}