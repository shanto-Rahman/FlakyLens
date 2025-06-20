@Test public void jndiLocationFound(){
this.condition.setFoundLocation("java:/b");//IT
assertThat(outcome.isMatch(),equalTo(true));
}