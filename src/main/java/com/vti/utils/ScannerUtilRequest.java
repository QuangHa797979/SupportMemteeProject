//package com.vti.utils;
//
//import java.util.Scanner;
//
//public class ScannerUtilRequest {
//
//	public static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
//			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
//	public static final String PATTERN_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])[a-zA-Z\\d]{6,12}$";
//	public static final String PATTERN_STRING = "[A-z0-9]{1,}";
//	public static final String PATTERN_PHONE = "^[0-9]{9,12}$";
//	public static final String PATTERN_STATUS_1 = "send";
//	public static final String PATTERN_STATUS_2 = "pending";
//	public static final String PATTERN_STATUS_3 = "approve";
//	public static final String PATTERN_STATUS_4 = "refuse";
//	
//	
//	private static void showError(String message) {
//		System.out.println("Error:" + message);
//	}
//
//	public static int readInt(Scanner scanner, String errorMessage) {
//		while (true) {
//			try {
//				return Integer.parseInt(scanner.nextLine());
//			} catch (Exception e) {
//				showError(errorMessage);
//			}
//		}
//	}
//
//	public static double readDouble(Scanner scanner, String errorMessage) {
//		while (true) {
//			try {
//				return Double.parseDouble(scanner.nextLine());
//			} catch (Exception e) {
//				showError(errorMessage);
//			}
//		}
//	}
//
//	public static float readFloat(Scanner scanner, String errorMessage) {
//		while (true) {
//			try {
//				return Float.parseFloat(scanner.nextLine());
//			} catch (Exception e) {
//				showError(errorMessage);
//			}
//		}
//	}
//
//	public static String readString(Scanner scanner, String errorMessage) {
//		while (true) {
//			try {
//				String resrult = scanner.nextLine().trim();
//				if (resrult != null & !resrult.isEmpty()) {
//					return resrult;
//				}
//			} catch (Exception e) {
//				showError(errorMessage);
//			}
//		}
//	}
//
//	public static String readPhone(Scanner scanner, String errorMessage) {
//		while (true) {
//			try {
//				String result = scanner.nextLine().trim();
//				if (result != null & !result.isEmpty()) {
//					if (result.matches(PATTERN_PHONE)) {
//						return result;
//					} else {
//						System.out.println("Phone is not true pattern! Try again");
//					}
//				}
//			} catch (Exception e) {
//				showError(errorMessage);
//			}
//		}
//	}
//
//	public static String readEmail(Scanner scanner, String errorMessage) {
//		while (true) {
//			try {
//				String result = scanner.nextLine().trim();
//				if (result != null & !result.isEmpty()) {
//					if (result.matches(PATTERN_EMAIL)) {
//						return result;
//					} else {
//						System.out.println("Email is not true pattern! Try again");
//					}
//				}
//			} catch (Exception e) {
//				showError(errorMessage);
//			}
//		}
//	}
//
//	public static String readProjectName(Scanner scanner, String errorMessage) {
//		while (true) {
//			try {
//				String result = scanner.nextLine().trim();
//				if (result != null & !result.isEmpty()) {
//					if (result.matches(PATTERN_PROJECTNAME_1) || result.matches(PATTERN_PROJECTNAME_2)
//							|| result.matches(PATTERN_PROJECTNAME_3)) {
//						return result;
//					} else {
//						System.out.println("ProjectName must be Testing System or CRM or TimeSheet");
//					}
//				}
//			} catch (Exception e) {
//				showError(errorMessage);
//			}
//		}
//	}
//
//	public static String readPassword(Scanner scanner, String errorMessage) {
//		while (true) {
//			try {
//				String result = scanner.nextLine().trim();
//				if (result != null & !result.isEmpty()) {
//					if (result.matches(PATTERN_PASSWORD)) {
//						return result;
//					} else {
//						System.out.println("Password is not true pattern! Try again");
//					}
//				}
//			} catch (Exception e) {
//				System.out.println("ErrorMessage!");
//			}
//		}
//	}
//}
