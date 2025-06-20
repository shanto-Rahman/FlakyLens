@Test public void should_parse_embedded_id() throws Exception {
assertThat(meta.getPropertyName()).isEqualTo("id");
assertThat(meta.<EmbeddedKey>getValueClass()).isEqualTo(EmbeddedKey.class);
assertThat(embeddedIdProperties).isNotNull();
assertThat(embeddedIdProperties.getComponentClasses()).contains(Long.class,String.class);
assertThat(embeddedIdProperties.getComponentNames()).contains("id","name");
assertThat(embeddedIdProperties.getComponentFields()).contains(userIdField,nameField);
assertThat(embeddedIdProperties.getComponentGetters()).contains(userIdGetter,nameGetter);
assertThat(embeddedIdProperties.getComponentSetters()).contains(userIdSetter,nameSetter);
assertThat(context.getPropertyMetas()).hasSize(1);
}