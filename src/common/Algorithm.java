package common;

import java.util.Locale;

public class Algorithm {

    validation validation = new validation();

    public String generateCaptchaText() {
        StringBuilder captcha = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            char randomChar = (char) ((int) (Math.random() * 26) + 'A');
            captcha.append(randomChar);
        }
        return captcha.toString();
    }

    public void login(Locale language) {
        validation.getWordLanguage(language, "enterAccountNumber");
        validation.checkInputAccount(language);
        validation.getWordLanguage(language, "enterPassword");
        validation.checkInputPassword(language);
        String captchaGenerated = generateCaptchaText();
        while (true) {
            if (validation.checkInputCaptcha(captchaGenerated, language)) {
                validation.getWordLanguage(language, "loginSuccess");
                System.out.println();
                return;
            } else {
                validation.getWordLanguage(language, "errCaptchaIncorrect");
                System.out.println();
            }
        }
    }
}


