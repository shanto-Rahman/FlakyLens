@Test public void should_fail_if_actual_is_not_file(){
File notAFile=new File("xyz");//RO
files.assertHasBinaryContent(info,notAFile,expected);//RW
}