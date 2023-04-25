import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class FileText {
    static List<Account> accounts = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    List<Account> accountList;

    public void loginAccount() throws IOException {
        readFile(accountList);
        System.out.println("Enter username here: ");
        String user = scanner.nextLine();
        System.out.println("Enter password here: ");
        String pass = scanner.nextLine();

        for (Account c : accountList) {
            if (c.getUserName().equalsIgnoreCase(user) && c.getPassword().equalsIgnoreCase(pass)) {
                System.out.println("Login Success");
            } else {
                System.out.println("Incorrect account or password !");
            }
            break;
        }
    }

    public void createAccount() {
        System.out.println("Enter account id");
        String id = scanner.nextLine();
        System.out.println("Enter username here: ");
        String userName = scanner.nextLine();
        System.out.println("Enter password here: ");
        String password = scanner.nextLine();
        System.out.println("Enter fullname here: ");
        String fullName = scanner.nextLine();
        System.out.println("Enter phonme number here: ");
        String phoneNumber = scanner.nextLine();
        System.out.println("Enter address here: ");
        String address = scanner.nextLine();
        Account account = new Account(id, userName, password, fullName, phoneNumber, address);
        accountList.add(account);
        writeFile(accountList);
    }
    public static void readFile(List<Account> accountList) throws IOException {
        File f = new File("D:\\untitled9\\src\\Accounts.txt");
        FileReader fileReader = new FileReader(f);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String c;
        String[] arrNew;
        while ((c = bufferedReader.readLine()) != null) {
            arrNew = c.split(",");
            accountList.add(new Account(arrNew[1], arrNew[2], arrNew[3], arrNew[4], arrNew[5], arrNew[6]));
        }
        bufferedReader.close();
        fileReader.close();
    }
    private void writeFile(List<Account> accountList) {
        File f = new File("D:\\untitled9\\src\\Accounts.txt");
        try {
            if (!f.exists()) {
                throw new FileNotFoundException();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(f, true));
            for (Account account : this.accountList) {
                bufferedWriter.write(account.toString() + "\n");
            }
            bufferedWriter.close();
        } catch (IOException e) {
            System.err.println("Error " + e);
        }
    }
}