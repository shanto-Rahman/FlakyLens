@Test public void customFreeMarkerSettings(){
assertThat(this.context.getBean(VelocityConfigurer.class).getVelocityEngine().getProperty("directive.parse.max.depth"),equalTo((Object)"10"));
}