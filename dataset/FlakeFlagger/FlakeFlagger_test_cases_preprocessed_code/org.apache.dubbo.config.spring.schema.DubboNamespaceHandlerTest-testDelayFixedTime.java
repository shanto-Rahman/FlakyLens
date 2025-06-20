@Test public void testDelayFixedTime(){
assertThat(ctx.getBean(ServiceBean.class).getDelay(),is(300));
}