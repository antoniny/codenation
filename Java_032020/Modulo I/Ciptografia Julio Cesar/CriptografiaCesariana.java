package challenge;

public class CriptografiaCesariana implements Criptografia {
    private final int CASAS_CRYPT = 3;
    private final int CASAS_DESCRYPT = (26-(CASAS_CRYPT % 26));

    @Override
    public String criptografar(String texto) {
        return convertMessage(texto.toLowerCase(),CASAS_CRYPT);
    }

    @Override
    public String descriptografar(String texto) {
        return convertMessage(texto.toLowerCase(),CASAS_DESCRYPT);
    }

    private String convertMessage(String message, int offset)  {
        if (message.trim().isEmpty()) {throw new IllegalArgumentException();};
        if (message == null) {throw new NullPointerException();};

        StringBuilder result = new StringBuilder();
        for (char character : message.toCharArray()) {
            if (isValidCharacter(character)) {
                int originalAlphabetPosition = character - 'a';
                int newAlphabetPosition = (originalAlphabetPosition + offset) % 26;
                char newCharacter = (char) ('a' + newAlphabetPosition);
                result.append(newCharacter);
            } else {
                result.append(character);
            }
        }
        return String.valueOf(result);
    }

    private boolean isValidCharacter(char character){
        return (character != '.')&&(character != ' ')&&(character < '0' || character > '9');
    }
}
