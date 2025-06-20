@Test public void testThatSettingOfMimeTypeWorks(){
assertEquals("application/dxf;charset=UTF-8",httpResponse.getHeaders("Content-Type")[0].getValue());
}