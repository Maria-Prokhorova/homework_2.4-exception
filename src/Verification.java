public class Verification {
    public static void dataVerification(String login, String password, String confirmPassword) {
        try {
            loginCheck(login);
        } catch (WrongLoginException exp) {
            System.out.println(exp.getMessage());
        }
        try {
            passwordCheck(password, confirmPassword);
        } catch (WrongPasswordException exp) {
            System.out.println(exp.getMessage());
        } finally {
            System.out.println("Валидация данных завершена");
        }
    }

    private static void loginCheck(String login) throws WrongLoginException {
        String arrayValidValues = "1234567890_qazwsxedcrfvtgbyhnujmikolpQAZWSXEDCRFVTGBYHNUJMIKOLP";
        boolean flag = true;
        String s;
        for (int index = 0; index < login.length(); index++) {
            s = String.valueOf(login.charAt(index));
            if (!arrayValidValues.contains(s)) {
                flag = false;
                break;
            }
        }
        if (!flag || login.length() > 20) {
            throw new WrongLoginException("Логин не соответствует требованиям");
        }
    }

    private static void passwordCheck(String password, String confirmPassword) throws WrongPasswordException {
        String arrayValidValues = "1234567890_qazwsxedcrfvtgbyhnujmikolpQAZWSXEDCRFVTGBYHNUJMIKOLP";
        boolean flag = true;
        String s;
        for (int index = 0; index < password.length(); index++) {
            s = String.valueOf(password.charAt(index));
            if (!arrayValidValues.contains(s)) {
                flag = false;
                break;
            }
        }
        if (!flag || password.length() > 20) {
            throw new WrongPasswordException("Пароль не соответствует требованиям");
        }

        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают");
        }
    }
}
