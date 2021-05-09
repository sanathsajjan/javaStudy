package com.java.practice.eft;

public class StringTest {
	public static void main(String[] args) {
		/*String credit_text = "We have CREDITED your account:";
		String question = "Any questions, please contact your banker.";
		String bankName = "Bank Name:";
		String on = " on ";
		String forText = "for $";
		String ABA = "ABA:";
		String originatorText = "Originator Info:";
		String name = "Name:";
		String beneficiaryInfo = "Beneficiary Info:";*/
		
		String DELIMITER = ":";
		String TOKEN_FUNDS_CREDITED = "We have CREDITED your account:";
		String TOKEN_QUESTION = "Any questions, please contact your banker.";
		String TOKEN_BANK_NAME = "Bank Name:";
		String TOKEN_ON = " on ";
		String TOKEN_FOR = "for $";
		String TOKEN_ABA_NO = "ABA:";
		String TOKEN_ORIGINATOR_INFO = "Originator Info:";
		//String TOKEN_SENDER_NAME = "Name:";
		String TOKEN_BENEFICIARY_INFO = "Beneficiary Info:";
		String TOKEN_OMAD = "OMAD Reference:";
		String TOKEN_SENDER_HEADER = "Sender:";
		String TOKEN_ORG_BANK_INFO = "Originator Bank Info:";
		String TOKEn_REFERENCE = "Reference:";
		
			
		

		String contents = "We have CREDITED your account: 12345* on 2020-01-13 for $100.00 \n" + 
				"Any questions, please contact your banker.\n" + 
				"Message ID: ***************** \n" + 
				"OMAD Reference: 2020*************************** \n" + 
				"\n" + 
				"Sender:\n" + 
				"ABA: ********* \n" + 
				"Bank Name: Fake Bank \n" + 
				"Reference: ****ref123********** \n" + 
				"\n" + 
				"Originator Bank Info:\n" + 
				"NCC: \n" + 
				"Bank Name: \n" + 
				"\n" + 
				"Originator Info:\n" + 
				"Name: Fake Bank \n" + 
				"\n" + 
				"Beneficiary Info:\n" + 
				"Name: NATIONAL MORTGAGE INSURANCE CO \n" + 
				"Acct #: \n" + 
				"\n" + 
				"Beneficiary Bank: \n" + 
				"\n" + 
				"Originator to Beneficiary Info: \n" + 
				"\n" + 
				"Bank to Bank Info:\n" + 
				"";


		// String text = "We have CREDITED your account: 123456 on 2020-01-13 for
		// $100.00 Any questions, please contact your banker.";
		int creditStartIndex = contents.indexOf(TOKEN_FUNDS_CREDITED);
		int onIndex = contents.indexOf(TOKEN_ON);
		int forIndex = contents.indexOf(TOKEN_FOR);
		String accountNumber = contents.substring(creditStartIndex + 30, onIndex);

		String amount = null;

		System.out.println("account number: " + accountNumber);
		int accountNumberLength = accountNumber.length();

		String receivedDate = contents.substring(creditStartIndex + 30 + accountNumberLength + 4, forIndex);
		System.out.println("receivedDate: " + receivedDate);

		amount = contents.substring(forIndex + 5, contents.indexOf(TOKEN_QUESTION));

		System.out.println("payment amount:" + amount.trim());

		String abaNumber = contents.substring(contents.indexOf(TOKEN_ABA_NO) + 4, contents.indexOf(TOKEN_BANK_NAME));

		System.out.println("ABA#:" + abaNumber.trim());

		String senderName = contents.substring(contents.indexOf(TOKEN_ORIGINATOR_INFO) + 16, contents.indexOf(TOKEN_BENEFICIARY_INFO));
		String[] arr = senderName.split(DELIMITER);

		System.out.println("sender name : " + arr[1]);
		
		
		//OMAD ref number
		String omadRef;
		int startIndx = contents.indexOf(TOKEN_OMAD);
		int lastIndex = contents.indexOf(TOKEN_SENDER_HEADER);
		if (startIndx != -1 && lastIndex != -1) {
			omadRef = contents.substring(startIndx + 15, lastIndex);
			
			System.out.println("OMAD ref number: "+omadRef);
		}
		
		int referenceStartIndex = contents.lastIndexOf(TOKEn_REFERENCE);
		int referenceEndIndex = contents.indexOf(TOKEN_ORG_BANK_INFO);
		String reference = contents.substring(referenceStartIndex, referenceEndIndex);
		
		System.out.println("reference number:"+reference);

	}
}
