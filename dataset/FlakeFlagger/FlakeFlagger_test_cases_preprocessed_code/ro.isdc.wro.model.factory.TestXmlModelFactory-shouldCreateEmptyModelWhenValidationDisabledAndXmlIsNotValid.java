@Test public void shouldCreateEmptyModelWhenValidationDisabledAndXmlIsNotValid(){
assertEquals(new WroModel(),factory.create());
}