@Test public void setAndGet(){
assertThat(AutoConfigurationPackages.get(context.getBeanFactory()),equalTo(Collections.singletonList(getClass().getPackage().getName())));
}