@Test public void should_fail_if_given_file_name_is_null(){
paths.assertHasFileName(info,existingFile,null);//RW
fail("expected a NullPointerException here");
assertThat(e).hasMessage("expected fileName should not be null");
}