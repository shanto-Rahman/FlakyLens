@Test public void setChunkedEncodingAsRequestProperty() throws IOException, InterruptedException {
connection.setDoOutput(true);//ET
connection.getOutputStream().write("ABC".getBytes("UTF-8"));//ET
assertEquals(200,connection.getResponseCode());
assertEquals("ABC",new String(request.getBody(),"UTF-8"));
}