@Test public void flatdir() throws Exception {
if (!this.libs.exists()) {
}
FileCopyUtils.copy(new File("src/test/resources/foo.jar"),new File(this.libs,"foo-1.0.0.jar"));//RO
}