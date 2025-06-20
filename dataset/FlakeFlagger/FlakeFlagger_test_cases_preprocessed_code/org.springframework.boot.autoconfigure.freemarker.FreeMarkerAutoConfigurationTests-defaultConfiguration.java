@Test public void defaultConfiguration(){
assertThat(this.context.getBean(FreeMarkerViewResolver.class),notNullValue());
assertThat(this.context.getBean(FreeMarkerConfigurer.class),notNullValue());
}