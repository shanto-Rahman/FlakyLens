@Test public void localFileTakesPrecedenceOverClasspath() throws Exception {
File localFile=new File(new File("."),"application.properties");//RO
assertThat(localFile.exists(),equalTo(false));
OutputStream out=new FileOutputStream(localFile);
assertThat(property,equalTo("fromlocalfile"));
}