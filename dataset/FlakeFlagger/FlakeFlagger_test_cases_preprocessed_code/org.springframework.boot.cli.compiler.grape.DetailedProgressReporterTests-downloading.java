@Test public void downloading() throws TransferCancelledException {
assertEquals(String.format("Downloading: %s%s%n",REPOSITORY,ARTIFACT),new String(this.baos.toByteArray()));
}