@Test public void testGetFiles() throws Exception {
Assertions.assertThat(rootFiles).hasSize(2);
if (f.isDirectory()) {
Assertions.assertThat(f.getName()).isEqualTo("dir1");
Assertions.assertThat(f.getName()).isEqualTo("rootfile.nc");
}
Assertions.assertThat(middleDir).hasSize(1);
Assertions.assertThat(f.isDirectory()).isTrue();
Assertions.assertThat(f.getName()).isEqualTo("dir2");
Assertions.assertThat(leaves).hasSize(3);
Assertions.assertThat(f.isDirectory()).isFalse();
Assertions.assertThat(f.getName()).matches("nested_file\\d\\.nc");
}