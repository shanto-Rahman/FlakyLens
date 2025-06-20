@Test public void should_create_new_temporary_folder(){
assertTrue(f.isDirectory());
if (f != null) f.delete();
}