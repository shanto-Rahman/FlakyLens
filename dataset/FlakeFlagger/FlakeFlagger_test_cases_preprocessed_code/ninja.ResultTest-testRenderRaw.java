@Test public void testRenderRaw() throws Exception {
assertEquals(byteArrayOutputStream.toString(),stringToRender);
assertEquals(Result.APPLICATON_JSON,result.getContentType());
}