@Test public void defaultConfiguration(){
assertThat(this.context.getBean(GroovyTemplateViewResolver.class),notNullValue());
}