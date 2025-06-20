@Test public void sourceClassIncluded(){
assertTrue("Wrong output: " + this.output,this.output.toString().contains("Starting " + getClass().getSimpleName()));
}