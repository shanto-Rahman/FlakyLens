@Test public void shouldCreateValidModelWhenAutoDetectIsTrue() throws Exception {
final File wroFile=new File(getClass().getResource("subfolder/wro.json").toURI());//RO
Assert.assertNotNull(factory.create());
}