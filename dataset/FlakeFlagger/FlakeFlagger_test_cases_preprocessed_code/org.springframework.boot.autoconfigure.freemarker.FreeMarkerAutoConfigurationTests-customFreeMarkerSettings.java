@SuppressWarnings("deprecation") @Test public void customFreeMarkerSettings(){
assertThat(this.context.getBean(FreeMarkerConfigurer.class).getConfiguration().getSetting("boolean_format"),equalTo("yup,nope"));
}