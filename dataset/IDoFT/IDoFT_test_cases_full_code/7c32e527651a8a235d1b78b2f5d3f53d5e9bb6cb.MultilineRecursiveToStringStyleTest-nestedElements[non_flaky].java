@Test public void nestedElements(){
  final Customer customer=new Customer("Douglas Adams");
  final Bank bank=new Bank("ASF Bank");
  customer.bank=bank;
  final String exp=getClassPrefix(customer) + "[" + BR+ "  accounts=<null>,"+ BR+ "  bank="+ getClassPrefix(bank)+ "["+ BR+ "    name=ASF Bank"+ BR+ "  ],"+ BR+ "  name=Douglas Adams"+ BR+ "]";
  assertEquals(exp,toString(customer));
}
