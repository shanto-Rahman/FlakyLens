@Test public void setChunkedStreamingMode() throws IOException, InterruptedException {
OutputStream outputStream=connection.getOutputStream();//ET
assertEquals(200,connection.getResponseCode());
assertEquals(body,new String(request.getBody(),"US-ASCII"));
assertEquals(Arrays.asList(body.length()),request.getChunkSizes());
}