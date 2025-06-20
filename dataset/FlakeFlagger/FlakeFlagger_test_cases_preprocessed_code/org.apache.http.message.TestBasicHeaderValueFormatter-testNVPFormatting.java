@Test public void testNVPFormatting() throws Exception {
Assert.assertEquals("param=regular_stuff",BasicHeaderValueFormatter.formatNameValuePair(param1,false,null));
Assert.assertEquals("param=\"this\\\\that\"",BasicHeaderValueFormatter.formatNameValuePair(param2,false,null));
Assert.assertEquals("param=\"this,that\"",BasicHeaderValueFormatter.formatNameValuePair(param3,false,null));
Assert.assertEquals("param=\"quote marks (\\\") must be escaped\"",BasicHeaderValueFormatter.formatNameValuePair(param4,false,null));
Assert.assertEquals("param=\"back slash (\\\\) must be escaped too\"",BasicHeaderValueFormatter.formatNameValuePair(param5,false,null));
Assert.assertEquals("param=\"values with\tblanks must always be quoted\"",BasicHeaderValueFormatter.formatNameValuePair(param6,false,null));
Assert.assertEquals("param",BasicHeaderValueFormatter.formatNameValuePair(param7,false,null));
Assert.assertEquals("param=\"regular_stuff\"",BasicHeaderValueFormatter.formatNameValuePair(param1,true,null));
Assert.assertEquals("param=\"this\\\\that\"",BasicHeaderValueFormatter.formatNameValuePair(param2,true,null));
Assert.assertEquals("param=\"this,that\"",BasicHeaderValueFormatter.formatNameValuePair(param3,true,null));
Assert.assertEquals("param=\"quote marks (\\\") must be escaped\"",BasicHeaderValueFormatter.formatNameValuePair(param4,true,null));
Assert.assertEquals("param=\"back slash (\\\\) must be escaped too\"",BasicHeaderValueFormatter.formatNameValuePair(param5,true,null));
Assert.assertEquals("param=\"values with\tblanks must always be quoted\"",BasicHeaderValueFormatter.formatNameValuePair(param6,true,null));
Assert.assertEquals("param",BasicHeaderValueFormatter.formatNameValuePair(param7,false,null));
}