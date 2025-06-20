@Test(expected=WroRuntimeException.class) public void testWithInvalidWroFileSet() throws Exception {
final File wroFile=new File("/path/to/invalid/wro.xml");//RO
Assert.assertNotNull(factory.create());
}