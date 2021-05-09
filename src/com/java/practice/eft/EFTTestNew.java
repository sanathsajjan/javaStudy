package com.java.practice.eft;

import java.io.FileInputStream;

public class EFTTestNew {

	// private static final String DELIMITER =
	// ":";/*-?|US8216_R5_Sprint4|venkatesh.nalam|c2|?*/
	private static final String TOKEN_COMMA = ",";
	// Oprivate static final String TOKEN_HTML_CONTENT = "<html";
	// private static final String TOKEN_FOR = "received for $";
	// private static final String TOKEN_FUNDS_CREDITED = "We have CREDITED your
	// account";
	// private static final String TOKEN_ABA_NO = "ABA";//old
	private static final String TOKEN_RECEIVED_FROM = "Received from";
	private static final String TOKEN_BY_ORDER_OF = "By Order Of";
	private static final String TOKEN_REFERENCE_NO = "Reference #";
	private static final String TOKEN_OMAD_REFERENCE_NO = "OMAD Reference #";
	private static final String TOKEN_VALUE_DATE = "Value Date";

	private static final String DELIMITER = ":";
	private static final String TOKEN_FUNDS_CREDITED = "We have CREDITED your account:";
	private static final String TOKEN_QUESTION = "Any questions, please contact your banker.";
	private static final String TOKEN_BANK_NAME = "Bank Name:";
	private static final String TOKEN_ON = " on ";
	private static final String TOKEN_FOR = "for $";
	private static final String TOKEN_ABA_NO = "ABA:";
	private static final String TOKEN_ORIGINATOR_INFO = "Originator Info:";
	private static final String TOKEN_BENEFICIARY_INFO = "Beneficiary Info:";
	private static final String TOKEN_OMAD = "OMAD Reference:";
	private static final String TOKEN_SENDER_HEADER = "Sender:";
	private static final String TOKEN_ORG_BANK_INFO = "Originator Bank Info:";
	private static final String TOKEn_REFERENCE = "Reference:";

	// private static final String DEFAULT_WIRE_ATTRIBUTE = "?";
	// private static final String TOKEN_ADDTIONAL_FUND = "Additional Funds";

	public void processContentNew(String contents) {

		int creditStartIndex = contents.indexOf(TOKEN_FUNDS_CREDITED);
		int onIndex = contents.indexOf(TOKEN_ON);
		int forIndex = contents.indexOf(TOKEN_FOR);
		String accountNumber = contents.substring(creditStartIndex + 30, onIndex);
		String receivedDate = contents.substring(creditStartIndex + 30 + accountNumber.length() + 4, forIndex);
		System.out.println(receivedDate);

		String paymentStr = contents.substring(forIndex + 5, contents.indexOf(TOKEN_QUESTION)).trim();
		if (paymentStr.endsWith(".")) {
			paymentStr = paymentStr.substring(0, paymentStr.length() - 1);
		}
		paymentStr = paymentStr.replaceAll(TOKEN_COMMA, "");

		String abaNumber = contents.substring(contents.indexOf(TOKEN_ABA_NO) + 4, contents.indexOf(TOKEN_BANK_NAME));
		System.out.println(abaNumber);

		String senderNameRef = contents.substring(contents.indexOf(TOKEN_ORIGINATOR_INFO) + 16,
				contents.indexOf(TOKEN_BENEFICIARY_INFO));
		String[] senderNameArr = senderNameRef.split(DELIMITER);
		System.out.println(senderNameArr[1]);

		// Reference number:
		// OMAD ref number
		String omadRef;
		int startIndx = contents.indexOf(TOKEN_OMAD);
		int lastIndex = contents.indexOf(TOKEN_SENDER_HEADER);
		if (startIndx != -1 && lastIndex != -1) {
			omadRef = contents.substring(startIndx + 15, lastIndex);

			System.out.println("OMAD ref number: " + omadRef);
		}
		int referenceStartIndex = contents.lastIndexOf(TOKEn_REFERENCE);
		int referenceEndIndex = contents.indexOf(TOKEN_ORG_BANK_INFO);
		String reference = contents.substring(referenceStartIndex, referenceEndIndex);

		System.out.println("reference number:" + reference);

		// int beginAbANo = contents.indexOf(TOKEN_ABA_NO, 0);
		/*int endAbaNo = contents.indexOf(TOKEN_REFERENCE_NO, 0);
		// String abaNoStr = contents.substring(beginAbANo + 5, endAbaNo);
		// String[] abaNoStrArray = abaNoStr.split(DELIMITER);
		
		 * LOGGER.info("Email Wire Input routing number {}", abaNoStrArray[1].trim());
		 * etfWirePaymentProcessVo.setWireRoutingNumber(abaNoStrArray[1].trim());
		 

		int endRefNo = contents.indexOf(TOKEN_RECEIVED_FROM, 0);
		String refNoStr = contents.substring(endAbaNo + 11, endRefNo);
		String[] refNoStrArray = refNoStr.split(DELIMITER);
		// LOGGER.info("Email Wire Input reference number {}", refNoStrArray[1].trim());
		
		 * etfWirePaymentProcessVo.setWireReferenceNumber(
		 * StringUtils.isEmpty(refNoStrArray[1].trim()) ?
		 * getOmadRefranceNumber(contents) : refNoStrArray[1].trim());
		 

		int endReceivedFrom = contents.indexOf(TOKEN_BY_ORDER_OF, 0);
		String receivedFromStr = contents.substring(endRefNo + 13, endReceivedFrom);
		String[] receivedFromStrArray = receivedFromStr.split(DELIMITER);
		String senderName = receivedFromStrArray[1].trim();
		// etfWirePaymentProcessVo.setWireSenderName(senderName);

		// reading order by
		int beginValueDate = contents.indexOf(TOKEN_VALUE_DATE, 0);
		String byOrderOfStr = contents.substring(endReceivedFrom + 11, beginValueDate);
		String byOrderOfStrArray[] = byOrderOfStr.split(DELIMITER);
		String byOrderOf = byOrderOfStrArray[1].trim();*/
		/*
		 * if (StringUtils.isNotEmpty(byOrderOf)) {
		 * etfWirePaymentProcessVo.setWireSenderName(byOrderOf); }
		 */

		// US12162 - Parsing the Value Date from email. This will serve as Receipt Date
		// and EFT Date in Wire Receipt email
		/*
		 * int endIndexOfValueDate = contents.indexOf(TOKEN_OMAD_REFERENCE_NO, 0);
		 * String valueDateStr = contents.substring(beginValueDate + 10,
		 * endIndexOfValueDate); String valueDateArr[] = valueDateStr.split(DELIMITER,
		 * 2);
		 */
		/*
		 * etfWirePaymentProcessVo
		 * .setWireReceivedDate(DateUtil.getDateFromString(valueDateArr[1].trim(),
		 * DateUtil.DB_TIMESTAMP_WITH_TIMEZONE_FORMAT));
		 */

	}

	public String getWireAutoPaymentEmailContent(String path) throws Exception {
		FileInputStream fis = new FileInputStream(path);
		byte[] buffer = new byte[10];
		StringBuilder sb = new StringBuilder();
		while (fis.read(buffer) != -1) {
			sb.append(new String(buffer));
			buffer = new byte[10];
		}
		fis.close();

		String content = sb.toString();
		return content;
	}

	public void processContentOld(String contents) {

		/*
		 * if (null == etfWirePaymentProcessVo) { etfWirePaymentProcessVo = new
		 * EtfWirePaymentProcessVo(); }
		 */
		/*
		 * etfWirePaymentProcessVo.setWireContent(contents);
		 * 
		 * int indexOfHtmlPart = contents.indexOf(TOKEN_HTML_CONTENT); if
		 * (indexOfHtmlPart != -1) {
		 * etfWirePaymentProcessVo.setWireHtmlContent(contents.substring(indexOfHtmlPart
		 * )); } else { String textContent = contents;
		 * etfWirePaymentProcessVo.setWireHtmlContent(textContent.replaceAll("\n",
		 * "<br>").replaceAll(" ", "&nbsp;")); }
		 */

		int endIndexOfDate = contents.indexOf(TOKEN_FOR, 0);
		int endIndexOfAmount = contents.indexOf(TOKEN_FUNDS_CREDITED, 0);
		String paymentStr = contents.substring(endIndexOfDate + 14, endIndexOfAmount).trim();
		if (paymentStr.endsWith(".")) {
			paymentStr = paymentStr.substring(0, paymentStr.length() - 1);
		}
		paymentStr = paymentStr.replaceAll(TOKEN_COMMA, "");
		// LOGGER.info("Email Wire Input Content payment {}", paymentStr);
		System.out.println("Email Wire Input Content payment :" + paymentStr);
		// etfWirePaymentProcessVo.setWirePaymentAmount(new
		// BigDecimal(paymentStr.trim()));

		int beginAbANo = contents.indexOf(TOKEN_ABA_NO, 0);
		int endAbaNo = contents.indexOf(TOKEN_REFERENCE_NO, 0);
		String abaNoStr = contents.substring(beginAbANo + 5, endAbaNo);
		String[] abaNoStrArray = abaNoStr.split(DELIMITER);
		// LOGGER.info("Email Wire Input routing number {}", abaNoStrArray[1].trim());
		System.out.println("Email Wire Input routing number: " + abaNoStrArray[1].trim());
		// etfWirePaymentProcessVo.setWireRoutingNumber(abaNoStrArray[1].trim());

		int endRefNo = contents.indexOf(TOKEN_RECEIVED_FROM, 0);
		String refNoStr = contents.substring(endAbaNo + 11, endRefNo);
		String[] refNoStrArray = refNoStr.split(DELIMITER);
		// LOGGER.info("Email Wire Input reference number {}", refNoStrArray[1].trim());
		System.out.println("Email Wire Input reference number: " + refNoStrArray[1].trim());
		/*
		 * etfWirePaymentProcessVo.setWireReferenceNumber(
		 * StringUtils.isEmpty(refNoStrArray[1].trim()) ?
		 * getOmadRefranceNumber(contents) : refNoStrArray[1].trim());
		 */

		int endReceivedFrom = contents.indexOf(TOKEN_BY_ORDER_OF, 0);
		String receivedFromStr = contents.substring(endRefNo + 13, endReceivedFrom);
		String[] receivedFromStrArray = receivedFromStr.split(DELIMITER);
		String senderName = receivedFromStrArray[1].trim();
		// etfWirePaymentProcessVo.setWireSenderName(senderName);
		System.out.println("Sender name : " + senderName);

		// reading order by
		int beginValueDate = contents.indexOf(TOKEN_VALUE_DATE, 0);
		String byOrderOfStr = contents.substring(endReceivedFrom + 11, beginValueDate);
		String byOrderOfStrArray[] = byOrderOfStr.split(DELIMITER);
		String byOrderOf = byOrderOfStrArray[1].trim();
		System.out.println("by order of: " + byOrderOf);
		/*
		 * if (StringUtils.isNotEmpty(byOrderOf)) {
		 * etfWirePaymentProcessVo.setWireSenderName(byOrderOf); }
		 */

		// US12162 - Parsing the Value Date from email. This will serve as Receipt Date
		// and EFT Date in Wire Receipt email
		int endIndexOfValueDate = contents.indexOf(TOKEN_OMAD_REFERENCE_NO, 0);
		String valueDateStr = contents.substring(beginValueDate + 10, endIndexOfValueDate);
		String valueDateArr[] = valueDateStr.split(DELIMITER, 2);
		System.out.println("valueDateArr :" + valueDateArr[1]);
		/*
		 * etfWirePaymentProcessVo
		 * .setWireReceivedDate(DateUtil.getDateFromString(valueDateArr[1].trim(),
		 * DateUtil.DB_TIMESTAMP_WITH_TIMEZONE_FORMAT));
		 */

	}

	public static void main(String args[]) throws Exception {
		EFTTestNew test = new EFTTestNew();
		// String oldContent =
		// test.getWireAutoPaymentEmailContent("C:\\\\Users\\\\sanath.bt\\\\Desktop\\\\wireAutoPaymentEmail_old.txt");
		String newContent = test
				.getWireAutoPaymentEmailContent("C:\\\\Users\\\\sanath.bt\\\\Desktop\\\\wireAutoPaymentEmail_new.txt");
		// test.processContentOld(oldContent);
		test.processContentNew(newContent);
	}
}
