@Test public void should_create_new_temporary_file(){
assertTrue(f.isFile());
if (f != null) f.delete();
}