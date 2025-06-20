@Test public void testDeletePartialChunkWithOffsetUnsupportedRequest(){
fail("testDeleteChunkUnsupportedRequest");
assertEquals(ContainerProtos.Result.UNSUPPORTED_REQUEST,ex.getResult());
}