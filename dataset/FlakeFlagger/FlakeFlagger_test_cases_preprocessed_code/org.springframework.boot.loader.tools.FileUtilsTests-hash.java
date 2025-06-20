@Test public void hash() throws Exception {
OutputStream outputStream=new FileOutputStream(file);
assertThat(FileUtils.sha1Hash(file),equalTo("7037807198c22a7d2b0807371d763779a84fdfcf"));
}