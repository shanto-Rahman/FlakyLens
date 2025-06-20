@Test public void should_throw_error_if_expected_is_not_file(){
File notAFile=new File("xyz");//RO
files.assertSameContentAs(someInfo(),actual,notAFile);//RW
}