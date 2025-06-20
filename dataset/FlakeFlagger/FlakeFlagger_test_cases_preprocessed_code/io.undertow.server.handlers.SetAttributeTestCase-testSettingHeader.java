@Test public void testSettingHeader() throws IOException {
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals("/path/a-",result.getHeaders("foo")[0].getValue());
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals("/path/a-someQp",result.getHeaders("foo")[0].getValue());
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals("/path/a-[someQp, value2]",result.getHeaders("foo")[0].getValue());
}