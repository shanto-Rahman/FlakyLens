@Test public void testAssetsControllerNormalOperationModifiedNoCaching() throws Exception {
assertEquals(Result.SC_200_OK,resultCaptor.getValue().getStatusCode());
assertEquals("mimetype",result.getContentType());
assertEquals("testasset",byteArrayOutputStream.toString());
}