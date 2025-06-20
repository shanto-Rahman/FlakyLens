@Test public void disableCache(){
assertThat(this.context.getBean(GroovyTemplateViewResolver.class).getCacheLimit(),equalTo(0));
}