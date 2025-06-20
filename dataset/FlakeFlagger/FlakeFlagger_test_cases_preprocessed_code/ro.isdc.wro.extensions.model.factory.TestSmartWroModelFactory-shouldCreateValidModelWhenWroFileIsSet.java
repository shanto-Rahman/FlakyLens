@Test public void shouldCreateValidModelWhenWroFileIsSet() throws Exception {
final File wroFile=new File(getClass().getResource("wro.xml").toURI());//RO
Assert.assertNotNull(factory.create());
}