@Test public void jndiNotAvailable(){
this.condition.setJndiAvailable(false);//IT
assertThat(outcome.isMatch(),equalTo(false));
}