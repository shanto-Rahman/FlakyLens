@Test public void customMetadata() throws Exception {
File testArtifactDir=new File("target/repository/test/test/1.0.0");//RO
File testArtifact=new File(testArtifactDir,"test-1.0.0.properties");
PrintWriter writer=new PrintWriter(new FileWriter(testArtifact));
assertTrue(new File("target/repository/javax/ejb/ejb-api/3.0").isDirectory());//RO
}