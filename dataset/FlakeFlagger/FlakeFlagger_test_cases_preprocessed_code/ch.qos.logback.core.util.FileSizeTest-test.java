@Test public void test(){
assertEquals(8,fs.getSize());
assertEquals(8 * KB_CO,fs.getSize());//RW
assertEquals(8 * KB_CO,fs.getSize());//RW
assertEquals(12 * MB_CO,fs.getSize());//RW
assertEquals(5 * GB_CO,fs.getSize());//RW
}