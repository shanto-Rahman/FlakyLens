@Test public void testChunkedRequest() throws IOException {
connection=null;//RW
post.setEntity(new StringEntity(message)//RW
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
post.setEntity(new StringEntity(message)//RW
while (i <= message.length()) //RW
i=Math.min(i,message.length());//RW
outstream.write(message.getBytes(),l,i - l);//RW
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
}