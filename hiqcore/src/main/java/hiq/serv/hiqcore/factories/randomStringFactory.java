package hiq.serv.hiqcore.factories;

import hiq.serv.hiqcore.randomGeneratedString;

public class randomStringFactory {
    public String rand() {
        String str = new randomGeneratedString().randomString();
        return str;
    }
}
