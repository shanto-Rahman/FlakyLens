@Test public void performanceOneTreadTestWithLongText(){
  String requestString="";
  String responseString="";
  for (int i=0; i < 100; i++) {
    requestString+="world world";
    responseString+="hello world";
  }
  oneThreadExecute(requestString,responseString);
}
