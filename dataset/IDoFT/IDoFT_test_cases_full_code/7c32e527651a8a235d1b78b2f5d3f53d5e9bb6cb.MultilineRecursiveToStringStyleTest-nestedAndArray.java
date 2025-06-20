@Test public void nestedAndArray(){
  final Account acc=new Account();
  final Transaction tx1=new Transaction("2014.10.14",100);
  final Transaction tx2=new Transaction("2014.10.15",50);
  acc.transactions.add(tx1);
  acc.transactions.add(tx2);
  final String expected=getClassPrefix(acc) + "[" + BR+ "  owner=<null>,"+ BR+ "  transactions="+ getClassPrefix(acc.transactions)+ "{"+ BR+ "    "+ getClassPrefix(tx1)+ "["+ BR+ "      amount=100.0,"+ BR+ "      date=2014.10.14"+ BR+ "    ],"+ BR+ "    "+ getClassPrefix(tx2)+ "["+ BR+ "      amount=50.0,"+ BR+ "      date=2014.10.15"+ BR+ "    ]"+ BR+ "  }"+ BR+ "]";
  assertEquals(expected,toString(acc));
}
