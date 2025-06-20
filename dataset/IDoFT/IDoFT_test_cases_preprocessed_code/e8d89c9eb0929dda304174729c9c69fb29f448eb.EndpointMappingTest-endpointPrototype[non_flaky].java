@Test public void endpointPrototype() throws Exception {
assertThat(message).isEqualTo(messageContext);
assertThat(result).isNotNull();
assertThat(result).isNotNull();
assertThat(MyEndpoint.constructorCount).isEqualTo(2);//RW
MyEndpoint.reset();//IT
}