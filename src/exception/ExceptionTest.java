package exception;

public class ExceptionTest {

    public static void main(String[] args) {
        try{
            withdraw01(100);
        }catch (UserDefineException e){
            e.printStackTrace();
        } finally {
            System.out.println("final");
        }
    }


    public static void withdraw01 (int amount) throws UserDefineException {
        throw new UserDefineException();
    }

    private static class UserDefineException extends Exception {
        public UserDefineException () {
            System.out.println("에러발생");
        }
    }
}
