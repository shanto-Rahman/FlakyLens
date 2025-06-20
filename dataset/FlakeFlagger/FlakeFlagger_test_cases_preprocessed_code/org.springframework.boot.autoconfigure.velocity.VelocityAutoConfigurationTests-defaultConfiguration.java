@Test public void defaultConfiguration(){
assertThat(this.context.getBean(VelocityViewResolver.class),notNullValue());
assertThat(this.context.getBean(VelocityConfigurer.class),notNullValue());
}