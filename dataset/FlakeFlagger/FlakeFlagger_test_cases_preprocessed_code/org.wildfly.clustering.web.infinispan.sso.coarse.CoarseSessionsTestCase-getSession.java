@Test public void getSession(){
assertSame(expected,this.sessions.getSession(deployment));
assertNull(this.sessions.getSession(missingDeployment));
}